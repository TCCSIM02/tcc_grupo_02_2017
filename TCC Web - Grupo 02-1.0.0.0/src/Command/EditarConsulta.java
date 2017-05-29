package Command;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.ModelConsulta;

public class EditarConsulta implements Command{
	
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
				pStatusConsulta,  Double.parseDouble(pValorConsulta));
		RequestDispatcher view = null;
		
		try {
			modelConsulta.consultarConsultaCod();
		} catch (ClassNotFoundException e) {
		
			e.printStackTrace();
		}
			
		request.setAttribute("consultaTO", modelConsulta.getTO());
		view = request.getRequestDispatcher("AlterarConsulta.jsp");
		
		view.forward(request, response);

	}

}