package Command;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class Logoff implements Command{
	
	@Override
	public void executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		RequestDispatcher view = null;
		HttpSession session = request.getSession();

		session.invalidate();
		
		//System.out.println("passei por aqui");
		
		view = request.getRequestDispatcher("Login.jsp");
		
		view.forward(request, response);
		
	}	

}
