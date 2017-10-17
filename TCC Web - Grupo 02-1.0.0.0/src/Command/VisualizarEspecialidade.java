package Command;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Command.Command;
import Model.ModelEspecialidade;
import TO.TOEspecialidade;

public class VisualizarEspecialidade implements Command {
	
	@Override
	public void executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String pCodEspecialidade = request.getParameter("codEspecialidade");
		String pFlagAtivo = request.getParameter("flagAtivo");
		String pDescricao = request.getParameter("descricao");
		String pEspecialidade = request.getParameter("especialidade");
		
		int id = -1;
		try {
			id = Integer.parseInt(pCodEspecialidade);
		} catch (NumberFormatException e) {

		}
		/*ALTERAR ESSE NULL AQUI*/
		ModelEspecialidade modelEspecialidade = new ModelEspecialidade(id, pEspecialidade,pFlagAtivo, pDescricao);
		RequestDispatcher view = null;
		
		
		try {
			modelEspecialidade.consultarEspecialidadeCod();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		request.setAttribute("especialidadeTO",modelEspecialidade.getTO() );
		view = request.getRequestDispatcher("VisualizarEspecialidade.jsp");
		view.forward(request, response);

	}
	
	public int busca(ModelEspecialidade modelEspecialidade, ArrayList<TOEspecialidade> lista) {
		TOEspecialidade toEspecialidade;
		for(int i = 0; i < lista.size(); i++){
			toEspecialidade = lista.get(i);
			if(toEspecialidade.getCodEspecialidade() == modelEspecialidade.getCodEspecialidade()){
				return i;
			}
		}
		return -1;
	}

	
	

}
