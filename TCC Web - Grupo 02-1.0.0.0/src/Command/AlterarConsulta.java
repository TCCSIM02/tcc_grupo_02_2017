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


public class AlterarConsulta implements Command {

	@Override
	public void executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String pCodConsulta             =	request.getParameter("codConsulta");             
		String pDataHoraConsultaFinal   =	request.getParameter("dataHoraConsultaFinal");   
		String pDataHoraConsultaInicio  =	request.getParameter("dataHoraConsultaInicio");  
		String pDiagnostico             =	request.getParameter("diagnostico");             

		System.out.println("Cod a: " + pCodConsulta);
		System.out.println("id a: " + request.getParameter("id"));
		
		
		int id = -1;
		try {
			id = Integer.parseInt(pCodConsulta);
		} catch (NumberFormatException e) {

		}

		/*ALTERAR ESSE NULL AQUI*/
		/*ALTERAR ESSE NULL AQUI*/
		ModelConsulta modelConsulta = new ModelConsulta(id, 0, null, null, pDiagnostico);
		
		RequestDispatcher view = null;
		HttpSession session = request.getSession();
		
		modelConsulta.alterarConsulta();
		@SuppressWarnings("unchecked")
		ArrayList<TOConsulta> lista = (ArrayList<TOConsulta>)session.getAttribute("lista");
		
		int pos = busca(modelConsulta, lista);
		lista.remove(pos);
		lista.add(pos, modelConsulta.getTO());
		
		try {
			lista = modelConsulta.listarConsultas();
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		}
		
		session.setAttribute("lista", lista);
		request.setAttribute("consultaTO", modelConsulta.getTO());
		view = request.getRequestDispatcher("VisualizarConsulta.jsp");
	
		view.forward(request, response);
	}
	
	public int busca(ModelConsulta modelConsulta, ArrayList<TOConsulta> lista) {
		TOConsulta toConsulta;
		for(int i = 0; i < lista.size(); i++){
			toConsulta = lista.get(i);
			if(toConsulta.getCodConsulta() == toConsulta.getCodConsulta()){
				return i;
			}
		}
		return -1;
	}

	
}
