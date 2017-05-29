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

public class AlterarExame implements Command {
	
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
		
		ModelExame modelExame = new ModelExame(id, Double.parseDouble(pValorExame),pDescricao, pResultadoExame);
		RequestDispatcher view = null;
		HttpSession session = request.getSession();
		
		modelExame.alterarExame();
		@SuppressWarnings("unchecked")
		ArrayList<TOExame> lista = (ArrayList<TOExame>)session.getAttribute("lista");
		
		int pos = busca(modelExame, lista);
		lista.remove(pos);
		lista.add(pos, modelExame.getTO());
		
		try {
			lista = modelExame.listarExames();
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		}
		
		session.setAttribute("lista", lista);
		request.setAttribute("exameTO", modelExame.getTO());
		view = request.getRequestDispatcher("VisualizarExame.jsp");
	
		view.forward(request, response);
	}
	
	public int busca(ModelExame modelExame, ArrayList<TOExame> lista) {
		TOExame toExame;
		for(int i = 0; i < lista.size(); i++){
			toExame = lista.get(i);
			if(toExame.getCodExame() == toExame.getCodExame()){
				return i;
			}
		}
		return -1;
	}



}
