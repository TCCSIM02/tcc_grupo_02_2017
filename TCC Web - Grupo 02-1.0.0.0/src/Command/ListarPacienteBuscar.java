package Command;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Model.ModelPaciente;
import TO.TOPaciente;

public class ListarPacienteBuscar implements Command {

	
	@Override
	public void executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String chave = request.getParameter("data[search]");

		ModelPaciente modelPaciente = new ModelPaciente();

		ArrayList<TOPaciente> lista = null;

		HttpSession session = request.getSession();


		if (chave != null && chave.length() > 0) {

			try {
				lista = modelPaciente.listarPacientes(chave);
			} catch (ClassNotFoundException e) {
				
				e.printStackTrace();
			}

		} else {

			try {
				lista = modelPaciente.listarPacientes();
			} catch (ClassNotFoundException e) {
				
				e.printStackTrace();
			}

		}
		
		session.setAttribute("lista", lista);
		RequestDispatcher dispatcher = request
				.getRequestDispatcher("ListarPaciente.jsp");
		dispatcher.forward(request, response);

	}

}
