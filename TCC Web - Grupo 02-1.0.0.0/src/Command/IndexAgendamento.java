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
import Model.ModelEspecialidade;
import Model.ModelMedico;
import TO.TOEspecialidade;
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
		
		
		/*TUDO PARA LISTAR OS MÉDICOS NO COMBOBOX*/
		ModelMedico modelMedico = new ModelMedico(); 
		
		ArrayList<TOMedico> lista = new ArrayList<>(); 
		try {
			lista = modelMedico.listarMedicos();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		
		session.setAttribute("lista", lista);	
		/*TUDO PARA LISTAR OS MÉDICOS NO COMBOBOX*/
		
		
		/*TUDO PARA LISTAR AS ESPECIALIDADES NO COMBOBOX*/
		ModelEspecialidade modelEspecialidade = new ModelEspecialidade(); 
		
		ArrayList<TOEspecialidade> listaEspecialidade = new ArrayList<>(); 
		try {
			listaEspecialidade = modelEspecialidade.listarEspecialidades();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		
		session.setAttribute("listaEspecialidade", listaEspecialidade);	
		/*TUDO PARA LISTAR AS ESPECIALIDADES NO COMBOBOX*/
		
		
		try {
			session.setAttribute("jsonCalendario", modelAgendamento.jsonCalendario());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 
		view.forward(request, response);
	}
}
