package Command;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class EfetuarLogin implements Command{

	@Override
	public void executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
		
		System.out.println("Button funcionou");
		
		RequestDispatcher view = request.getRequestDispatcher("ListarPlano.jsp");
		view.forward(request, response);
		
	}	
}
