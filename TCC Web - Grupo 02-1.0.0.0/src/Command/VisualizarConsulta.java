package Command;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Command.Command;
import Model.ModelConsulta;
import TO.TOConsulta;

public class VisualizarConsulta implements Command {
	
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
		request.setAttribute("consultaTO",modelConsulta.getTO() );
		view = request.getRequestDispatcher("VisualizarConsulta.jsp");
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
