package Command;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Model.ModelConsulta;
import TO.TOConsulta;


public class ListarConsultaBuscar implements Command {
	
	@Override
	public void executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String chave = request.getParameter("data[search]");

		ModelConsulta modelConsulta = new ModelConsulta();

		ArrayList<TOConsulta> lista = null;

		HttpSession session = request.getSession();


		if (chave != null && chave.length() > 0) {

			/*try {
				lista = modelConsulta.listarConsultas(chave);
			} catch (ClassNotFoundException e) {
				
				e.printStackTrace();
			}*/

		} else {

			try {
				lista = modelConsulta.listarConsultas();
			} catch (ClassNotFoundException e) {
				
				e.printStackTrace();
			}

		}
		
		session.setAttribute("lista", lista);
		RequestDispatcher dispatcher = request
				.getRequestDispatcher("ListarConsulta.jsp");
		dispatcher.forward(request, response);

	}

}
