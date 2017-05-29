package Command;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Model.ModelPromocao;
import TO.TOPromocao;


public class ListarPromocaoBuscar implements Command {
	
	@Override
	public void executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String chave = request.getParameter("data[search]");

		ModelPromocao modelPromocao = new ModelPromocao();

		ArrayList<TOPromocao> lista = null;

		HttpSession session = request.getSession();


		if (chave != null && chave.length() > 0) {

			try {
				lista = modelPromocao.listarPromocoes(chave);
			} catch (ClassNotFoundException e) {
				
				e.printStackTrace();
			}
			
		} else {

			try {
				lista = modelPromocao.listarPromocoes();
			} catch (ClassNotFoundException e) {
				
				e.printStackTrace();
			}

		}
		
		session.setAttribute("lista", lista);
		RequestDispatcher dispatcher = request
				.getRequestDispatcher("ListarPromocao.jsp");
		dispatcher.forward(request, response);

	}

}
