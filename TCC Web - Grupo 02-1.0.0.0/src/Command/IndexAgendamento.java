package Command;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Model.ModelAgendamento;

public class IndexAgendamento implements Command {

	@Override
	public void executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		RequestDispatcher view = null;
		HttpSession session = request.getSession();
		
		ModelAgendamento modelAgendamento = new ModelAgendamento();

		modelAgendamento.preencherCalendario();
		view = request.getRequestDispatcher("IndexAgendamento.jsp");
	
		request.setAttribute("jsonCalendario", modelAgendamento.jsonCalendario());
		
		view.forward(request, response);
	}
}
