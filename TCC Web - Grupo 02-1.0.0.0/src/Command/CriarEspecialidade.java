package Command;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Model.ModelEspecialidade;
import TO.TOEspecialidade;


public class CriarEspecialidade implements Command {
	
	@Override
	public void executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


		String pCodEspecialidade = request.getParameter("codEspecialidade");
		String pFlagAtivo = request.getParameter("flagAtivo");
		String pEspecialidade = request.getParameter("especialidade");
		String pDescricao = request.getParameter("descricao");

		int id = -1;
		try {
			id = Integer.parseInt(pCodEspecialidade);
		} catch (NumberFormatException e) {

		}

		/*ALTERAR ESSE NULL AQUI*/
		ModelEspecialidade modelEspecialidade = new ModelEspecialidade(id, pEspecialidade,pFlagAtivo, pDescricao);
	
		HttpSession session = request.getSession();
		
		modelEspecialidade.cadastrarEspecialidade();
		ArrayList<TOEspecialidade> lista = new ArrayList<>();
		
		lista.add(modelEspecialidade.getTO());
		
		try {
			lista = modelEspecialidade.listarEspecialidades();
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		}
		
		session.setAttribute("lista", lista);
		RequestDispatcher view = request.getRequestDispatcher("ListarEspecialidade.jsp");
		view.forward(request, response);
		
	}


}
