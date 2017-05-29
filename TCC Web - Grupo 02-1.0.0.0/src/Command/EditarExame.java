package Command;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.ModelExame;

public class EditarExame implements Command {

	@Override
	public void executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String pCodExame 		= 	request.getParameter("id");
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
		RequestDispatcher view = null;
		
		try {
			modelExame.consultarExameCod();
		} catch (ClassNotFoundException e) {
		
			e.printStackTrace();
		}
			
		request.setAttribute("exameTO", modelExame.getTO());
		view = request.getRequestDispatcher("AlterarExame.jsp");
		
		view.forward(request, response);

	}

	
}
