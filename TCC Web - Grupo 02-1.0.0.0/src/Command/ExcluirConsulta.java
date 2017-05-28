package Command;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Model.ModelConsulta;
import TO.TOConsulta;

public class ExcluirConsulta implements Command {
	
	@Override
	public void executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String pCodConsulta             =	request.getParameter("codConsulta");             
		String pDataHoraConsultaFinal   =	request.getParameter("dataHoraConsultaFinal");   
		String pDataHoraConsultaInicio  =	request.getParameter("dataHoraConsultaInicio");  
		String pDiagnostico             =	request.getParameter("diagnostico");             
		String pStatusConsulta          =	request.getParameter("statusConsulta");          
		String pValorConsulta			=	request.getParameter("valorConsulta");	
		
		int id = -1;
		System.out.println("id: "+pCodConsulta );
		System.out.println("CodConsulta: "+request.getParameter("codConsulta"));
		
		
		try {
			id = Integer.parseInt(pCodConsulta);
		} catch (NumberFormatException e) {

		}

		/*ALTERAR ESSE NULL AQUI*/
		ModelConsulta modelConsulta = new ModelConsulta(id, null /*new Date(pDataHoraConsultaFinal)*/, null /* new Date(pDataHoraConsultaInicio)*/,  pDiagnostico,
				pStatusConsulta,  Double.parseDouble(pValorConsulta));
		RequestDispatcher view = null;
		HttpSession session = request.getSession();
		
		modelConsulta.excluirConsulta();
		
		@SuppressWarnings("unchecked")
		ArrayList<TOConsulta> lista = (ArrayList<TOConsulta>)session.getAttribute("lista");
				
		lista.remove(busca(modelConsulta, lista));
		
		try {
			lista = modelConsulta.listarConsultas();
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		}
		
		session.setAttribute("lista", lista);
		
		view = request.getRequestDispatcher("ListarConsulta.jsp");
		
		view.forward(request, response);
		
		
	}
	
	public int busca(ModelConsulta modelConsulta, ArrayList<TOConsulta> lista) {
		TOConsulta toConsulta;
		for(int i = 0; i < lista.size(); i++){
			toConsulta = lista.get(i);
			if(toConsulta.getCodConsulta() == modelConsulta.getCodConsulta()){
				return i;
			}
		}
		return -1;
	}


}
