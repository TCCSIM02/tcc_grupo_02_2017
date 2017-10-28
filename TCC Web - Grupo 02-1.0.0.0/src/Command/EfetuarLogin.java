package Command;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Model.ModelLogin;
import TO.TOLogin;

public class EfetuarLogin implements Command{

	@Override
	public void executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		RequestDispatcher view = null;
		HttpSession session = request.getSession();
		
		String txtUsuario = request.getParameter("txtUsuario");
		String txtSenha = request.getParameter("txtSenha");
		
		ModelLogin modelLogin = new ModelLogin();
		
		System.out.println(txtUsuario);
		
		ArrayList<TOLogin> listaLogin = new ArrayList<>(); 		
		
		try {
			listaLogin = modelLogin.buscarLogin(txtUsuario, txtSenha);
		} catch (ClassNotFoundException | NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//session.setAttribute("listaLogin", listaLogin);
		
		System.out.println(listaLogin);
		
		if(listaLogin.isEmpty()) {
			view = request.getRequestDispatcher("erro.jsp");				
		} else {
			view = request.getRequestDispatcher("IndexAgendamento.jsp");	
		} 
		
		
		
		view.forward(request, response);
		
	}	
}
