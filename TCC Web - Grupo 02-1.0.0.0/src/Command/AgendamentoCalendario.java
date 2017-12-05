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


public class AgendamentoCalendario implements Command {

	@Override
	public void executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		RequestDispatcher view = null;
		HttpSession session = request.getSession();
		
		String especialidadeValor = request.getParameter("especialidadeValor");
		String unidadeValor = request.getParameter("unidadeValor");
		String pacienteValor = request.getParameter("pacienteValor");
		
		ModelAgendamento modelAgendamento = new ModelAgendamento();
		ModelMedico modelMedico = new ModelMedico(); 

		try {
			modelAgendamento.preencherCalendario();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		
		ArrayList<TOMedico> listaMedico = new ArrayList<>(); 
		try {
			listaMedico = modelMedico.listarMedicoEspecialidadeUnidade(unidadeValor, especialidadeValor);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		
		session.setAttribute("listaMedico", listaMedico);		
		session.setAttribute("especialidadeValor", especialidadeValor);
		session.setAttribute("unidadeValor", unidadeValor);
		session.setAttribute("pacienteValor", pacienteValor);
		
		view = request.getRequestDispatcher("AgendamentoCalendario.jsp");	
		
		try {
			session.setAttribute("jsonCalendario", modelAgendamento.listarAgendamentosMedico(-1));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		view.forward(request, response);
	}
}
