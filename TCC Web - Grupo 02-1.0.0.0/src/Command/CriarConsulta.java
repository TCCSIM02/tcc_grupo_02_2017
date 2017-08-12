package Command;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Model.ModelConsulta;
import TO.TOConsulta;


public class CriarConsulta implements Command {
	
	@Override
	public void executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String pCodConsulta             =	request.getParameter("codConsulta");             
		String pDataHoraConsultaFinal   =	request.getParameter("dataHoraConsultaFinal");   
		String pDataHoraConsultaInicio  =	request.getParameter("dataHoraConsultaInicio");  
		String pDiagnostico             =	request.getParameter("diagnostico");             
		String pStatusConsulta          =	request.getParameter("statusConsulta");          
		String pValorConsulta			=	request.getParameter("valorConsulta");	
		
		int id = -1;
		try {
			id = Integer.parseInt(pCodConsulta);
		} catch (NumberFormatException e) {

		}

		/*ALTERAR ESSE NULL AQUI*/
		ModelConsulta modelConsulta = new ModelConsulta(id, null /*new Date(pDataHoraConsultaFinal)*/, null /* new Date(pDataHoraConsultaInicio)*/,  pDiagnostico,
				pStatusConsulta,  Double.parseDouble(pValorConsulta.replace(",",".")));
	
		HttpSession session = request.getSession();
		
		modelConsulta.cadastrarConsulta();
		ArrayList<TOConsulta> lista = new ArrayList<>(); 
		try {
			lista = modelConsulta.listarConsultas();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//lista.add(modelConsulta.getTO());
		
		session.setAttribute("lista", lista);		
		RequestDispatcher view = request.getRequestDispatcher("ListarConsulta.jsp");
		view.forward(request, response);
	}
}
