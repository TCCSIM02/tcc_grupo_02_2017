package Command;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Model.ModelEspecialidade;
import TO.TOEspecialidade;


public class ListarEspecialidadeBuscar implements Command {
	
	@Override
	public void executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String chave = request.getParameter("data[search]");

		ModelEspecialidade modelEspecialidade = new ModelEspecialidade();

		ArrayList<TOEspecialidade> lista = null;

		HttpSession session = request.getSession();


		if (chave != null && chave.length() > 0) {

			try {
				lista = modelEspecialidade.listarEspecialidades(chave);
			} catch (ClassNotFoundException e) {
				
				e.printStackTrace();
			}

		} else {

			try {
				lista = modelEspecialidade.listarEspecialidades();
			} catch (ClassNotFoundException e) {
				
				e.printStackTrace();
			}

		}
		
		session.setAttribute("lista", lista);
		RequestDispatcher dispatcher = request
				.getRequestDispatcher("ListarEspecialidade.jsp");
		dispatcher.forward(request, response);

	}

}
