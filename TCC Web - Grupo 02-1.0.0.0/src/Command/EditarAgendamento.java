package Command;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.ModelAgendamento;

public class EditarAgendamento implements Command{
	
	@Override
	public void executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String pCodAgendamento             =	request.getParameter("id");             
	
		int id = -1;
		try {
			id = Integer.parseInt(pCodAgendamento);
		} catch (NumberFormatException e) {

		}

		ModelAgendamento modelAgendamento = new ModelAgendamento(id);
		RequestDispatcher view = null;
		
			
		request.setAttribute("consultaTO", modelAgendamento.getTO());
		view = request.getRequestDispatcher("AlterarAgendamento.jsp");
		
		view.forward(request, response);

	}

}
