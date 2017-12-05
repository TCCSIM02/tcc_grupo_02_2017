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

public class PreenchePaciente implements Command {

	@Override
	public void executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		RequestDispatcher view = null;
		HttpSession session = request.getSession();
		
		ModelPlano modelPlano = new ModelPlano();
		
		ArrayList<TOPlano> listaPlano = new ArrayList<>(); 
		
		try {
			listaPlano = modelPlano.listarPlanos();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		session.setAttribute("listaPlano", listaPlano);
		
		view = request.getRequestDispatcher("CriarPaciente.jsp");
		
		view.forward(request, response);
	}
	
}