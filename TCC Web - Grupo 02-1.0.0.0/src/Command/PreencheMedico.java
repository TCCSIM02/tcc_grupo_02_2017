package Command;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Model.ModelEspecialidade;
import Model.ModelUnidade;
import TO.TOEspecialidade;
import TO.TOUnidade;

public class PreencheMedico implements Command {

	@Override
	public void executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		RequestDispatcher view = null;
		HttpSession session = request.getSession();
		
		ModelEspecialidade modelEspecialidade = new ModelEspecialidade();
		
		ModelUnidade modelUnidade = new ModelUnidade();
		
		
		ArrayList<TOEspecialidade> listaEspecialidade = new ArrayList<>(); 
		
		ArrayList<TOUnidade> listaUnidade = new ArrayList<>(); 
		
		try {
			listaEspecialidade = modelEspecialidade.listarEspecialidades();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			listaUnidade = modelUnidade.listarUnidades();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		session.setAttribute("listaEspecialidade", listaEspecialidade);
		
		session.setAttribute("listaUnidade", listaUnidade);
		
		view = request.getRequestDispatcher("CriarMedico.jsp");
		
		view.forward(request, response);
	}
	
}
