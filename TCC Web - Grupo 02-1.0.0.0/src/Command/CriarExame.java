package Command;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Model.ModelExame;
import TO.TOExame;


public class CriarExame implements Command  {
	
	@Override
	public void executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


		String pCodExame 		= 	request.getParameter("codExame");
		String pValorExame 		= 	request.getParameter("valorExame");
		String pDescricao	 	= 	request.getParameter("descricao");
		String pResultadoExame	=	request.getParameter("resultadoExame");


		int id = -1;
		try {
			id = Integer.parseInt(pCodExame);
		} catch (NumberFormatException e) {

		}

		/*ALTERAR ESSE NULL AQUI*/
		ModelExame modelExame = new ModelExame(id, Double.parseDouble(pValorExame),pDescricao, pResultadoExame);
	
		HttpSession session = request.getSession();
		
		modelExame.cadastrarExame();
		ArrayList<TOExame> lista = new ArrayList<>(); 
		try {
			lista = modelExame.listarExames();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//lista.add(modelExame.getTO());
		
		session.setAttribute("lista", lista);		
		RequestDispatcher view = request.getRequestDispatcher("ListarExame.jsp");
		view.forward(request, response);
		

	}



}
