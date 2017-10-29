package Command;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Model.ModelUnidade;
import TO.TOUnidade;

public class PreenchePlano implements Command {

	@Override
	public void executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		RequestDispatcher view = null;
		HttpSession session = request.getSession();
		
		ModelUnidade modelUnidade = new ModelUnidade();
		
		ArrayList<TOUnidade> listaUnidade = new ArrayList<>(); 
		
		try {
			listaUnidade = modelUnidade.listarUnidades();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		session.setAttribute("listaUnidade", listaUnidade);
		
		view = request.getRequestDispatcher("CriarPlano.jsp");
		
		view.forward(request, response);
	}
	
}
