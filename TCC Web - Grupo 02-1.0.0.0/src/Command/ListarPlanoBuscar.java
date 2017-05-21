package Command;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Model.ModelPlano;
import TO.TOPlano;


public class ListarPlanoBuscar implements Command {
	
	@Override
	public void executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String chave = request.getParameter("data[search]");

		ModelPlano modelPlano = new ModelPlano();

		ArrayList<TOPlano> lista = null;

		HttpSession session = request.getSession();


		if (chave != null && chave.length() > 0) {

			try {
				lista = modelPlano.listarPlanos(chave);
			} catch (ClassNotFoundException e) {
				
				e.printStackTrace();
			}

		} else {

			try {
				lista = modelPlano.listarPlanos();
			} catch (ClassNotFoundException e) {
				
				e.printStackTrace();
			}

		}
		
		session.setAttribute("lista", lista);
		RequestDispatcher dispatcher = request
				.getRequestDispatcher("ListarPlano.jsp");
		dispatcher.forward(request, response);

	}

}
