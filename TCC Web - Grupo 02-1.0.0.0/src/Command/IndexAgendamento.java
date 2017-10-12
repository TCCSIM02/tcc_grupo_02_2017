package Command;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Model.ModelAgendamento;
import Model.ModelMedico;
import TO.TOMedico;

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
		
		ModelMedico modelMedico = new ModelMedico(); 
		
		ArrayList<TOMedico> lista = new ArrayList<>(); 
		try {
			lista = modelMedico.listarMedicos();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		session.setAttribute("lista", lista);	
		
		try {
			session.setAttribute("jsonCalendario", modelAgendamento.jsonCalendario());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		view.forward(request, response);
	}
}
