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
		
		String pCodConsulta             =	request.getParameter("id");             
	
		int id = -1;
		try {
			id = Integer.parseInt(pCodConsulta);
		} catch (NumberFormatException e) {

		}

		ModelConsulta modelConsulta = new ModelConsulta(id);
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
