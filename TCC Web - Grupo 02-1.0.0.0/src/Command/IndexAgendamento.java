package Command;

import java.io.IOException;
import java.text.ParseException;

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

		try {
			modelAgendamento.preencherCalendario();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		view = request.getRequestDispatcher("IndexAgendamento.jsp");
	
		try {
			request.setAttribute("jsonCalendario", modelAgendamento.jsonCalendario());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		view.forward(request, response);
	}
}
