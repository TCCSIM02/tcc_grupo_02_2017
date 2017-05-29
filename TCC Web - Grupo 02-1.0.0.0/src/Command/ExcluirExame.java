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


public class ExcluirExame implements Command{
	
	@Override
	public void executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String pCodExame 		= 	request.getParameter("id");/*AJUSTADO*/
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
		HttpSession session = request.getSession();
		
		modelExame.excluirExame();
		
		@SuppressWarnings("unchecked")
		ArrayList<TOExame> lista = (ArrayList<TOExame>)session.getAttribute("lista");
				
		lista.remove(busca(modelExame, lista));
		
		try {
			lista = modelExame.listarExames();
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		}
		
		session.setAttribute("lista", lista);
		
		view = request.getRequestDispatcher("ListarExame.jsp");
		
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
