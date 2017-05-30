package Command;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.ModelExame;
import TO.TOExame;

public class VisualizarExame implements Command {
	

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
		ModelExame modelExame = new ModelExame(id, 0.0,pDescricao, pResultadoExame);
		RequestDispatcher view = null;
		
		try {
			modelExame.consultarExameCod();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		request.setAttribute("exameTO",modelExame.getTO() );
		view = request.getRequestDispatcher("VisualizarExame.jsp");
		view.forward(request, response);

	}
	
	public int busca(ModelExame modelExame, ArrayList<TOExame> lista) {
		TOExame toExame;
		for(int i = 0; i < lista.size(); i++){
			toExame = lista.get(i);
			if(toExame.getCodExame() == modelExame.getCodExame()){
				return i;
			}
		}
		return -1;
	}

	

}
