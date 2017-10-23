package Command;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Model.ModelEspecialidade;
import Model.ModelPaciente;
import TO.TOEspecialidade;
import TO.TOPaciente;

public class IndexAgendamento implements Command {

	@Override
	public void executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		RequestDispatcher view = null;
		HttpSession session = request.getSession();
		
		ModelPaciente modelPaciente = new ModelPaciente();
		ModelEspecialidade modelEspecialidade = new ModelEspecialidade();
		
		
		ArrayList<TOPaciente> listaPaciente = new ArrayList<>(); 
		ArrayList<TOEspecialidade> listaEspecialidade = new ArrayList<>(); 
		
		
		try {
			listaPaciente = modelPaciente.listarPacientes();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		try {
			listaEspecialidade = modelEspecialidade.listarEspecialidades();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		
		
		session.setAttribute("listaPaciente", listaPaciente);
		session.setAttribute("listaEspecialidade", listaEspecialidade);
		
		view = request.getRequestDispatcher("IndexAgendamento.jsp");
		
		view.forward(request, response);
	}
}
