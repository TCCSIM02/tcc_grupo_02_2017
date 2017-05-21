package Controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Command.Command;

@WebServlet(name = "controller.do", urlPatterns = { "/controller.do" })
public class ServletController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
	protected void doExecute(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		try {
			request.setCharacterEncoding("UTF-8");
			response.setCharacterEncoding("UTF-8");
			Command comando = (Command)Class.forName("Command."+request.getParameter("command")).newInstance();
			comando.executa(request, response);
		} catch (InstantiationException | IllegalAccessException
				| ClassNotFoundException e) {
			e.printStackTrace();
			throw new ServletException(e);
		}
	}



	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doExecute(request, response);
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doExecute(request, response);
		
	}
	
	/*protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doExecute(request, response);
		
	}*/

}
