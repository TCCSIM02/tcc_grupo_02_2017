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


public class AlterarPlano implements Command {

	@Override
	public void executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String pCodPlano = request.getParameter("codPlano");/*AJUSTADO*/
		String pNomePlano = request.getParameter("nomePlano");
		String pRegistroAns = request.getParameter("registroAns");
		String pTipoPlano = request.getParameter("tipoPlano");
		String pFlagAtivo = request.getParameter("flagAtivo");
		String pDataCadastro = request.getParameter("dataCadastro");

		int id = -1;
		try {
			id = Integer.parseInt(pCodPlano);
		} catch (NumberFormatException e) {

		}

		/*ALTERAR ESSE NULL AQUI*/
		ModelPlano modelPlano = new ModelPlano(id,pNomePlano,pRegistroAns,pTipoPlano, pFlagAtivo, null);
		RequestDispatcher view = null;
		HttpSession session = request.getSession();
		
		modelPlano.alterarPlano();
		@SuppressWarnings("unchecked")
		ArrayList<TOPlano> lista = (ArrayList<TOPlano>)session.getAttribute("lista");
		
		int pos = busca(modelPlano, lista);
		lista.remove(pos);
		lista.add(pos, modelPlano.getTO());
		
		try {
			lista = modelPlano.listarPlanos();
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		}
		
		session.setAttribute("lista", lista);
		request.setAttribute("planoTO", modelPlano.getTO());
		view = request.getRequestDispatcher("VisualizarPlano.jsp");
	
		view.forward(request, response);
	}
	
	public int busca(ModelPlano modelPlano, ArrayList<TOPlano> lista) {
		TOPlano toPlano;
		for(int i = 0; i < lista.size(); i++){
			toPlano = lista.get(i);
			if(toPlano.getCodPlano() == toPlano.getCodPlano()){
				return i;
			}
		}
		return -1;
	}

	
}
