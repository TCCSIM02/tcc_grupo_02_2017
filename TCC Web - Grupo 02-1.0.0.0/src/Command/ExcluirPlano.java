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

public class ExcluirPlano implements Command {
	
	@Override
	public void executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String pCodPlano = request.getParameter("id");
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
		
		modelPlano.excluirPlano();
		
		@SuppressWarnings("unchecked")
		ArrayList<TOPlano> lista = (ArrayList<TOPlano>)session.getAttribute("lista");
				
		lista.remove(busca(modelPlano, lista));
		
		try {
			lista = modelPlano.listarPlanos();
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		}
		
		session.setAttribute("lista", lista);
		
		view = request.getRequestDispatcher("ListarPlano.jsp");
		
		view.forward(request, response);
		
		
	}
	
	public int busca(ModelPlano modelPlano, ArrayList<TOPlano> lista) {
		TOPlano toPlano;
		for(int i = 0; i < lista.size(); i++){
			toPlano = lista.get(i);
			if(toPlano.getCodPlano() == modelPlano.getCodPlano()){
				return i;
			}
		}
		return -1;
	}


}
