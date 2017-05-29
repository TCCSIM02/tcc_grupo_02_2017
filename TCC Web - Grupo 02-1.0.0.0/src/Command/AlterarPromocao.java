package Command;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Model.ModelPromocao;
import TO.TOPromocao;


public class AlterarPromocao implements Command {

	@Override
	public void executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String pCodPromocao		=	request.getParameter("codPromocao");             
		String pDataCadastro    =	request.getParameter("dataCadastro");   
		String pDataInicio      =	request.getParameter("dataInicio");  
		String pDataTermino     =	request.getParameter("dataTermino");             
		String pFlagAtivo       =	request.getParameter("flagAtivo");          
		String pValorPromocao   =	request.getParameter("valorPromocao");

		int id = -1;
		try {
			id = Integer.parseInt(pCodPromocao);
		} catch (NumberFormatException e) {

		}

		/*ALTERAR ESSE NULL AQUI*/
		ModelPromocao modelPromocao = new ModelPromocao(id, Double.parseDouble(pValorPromocao), null /*new Date(pDataInicio)*/, null /*new Date(pDataCadastro)*/, null,
				pFlagAtivo);
		RequestDispatcher view = null;
		HttpSession session = request.getSession();
		
		modelPromocao.alterarPromocao();
		@SuppressWarnings("unchecked")
		ArrayList<TOPromocao> lista = (ArrayList<TOPromocao>)session.getAttribute("lista");
		
		int pos = busca(modelPromocao, lista);
		lista.remove(pos);
		lista.add(pos, modelPromocao.getTO());
		
		try {
			lista = modelPromocao.listarPromocoes();
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		}
		
		session.setAttribute("lista", lista);
		request.setAttribute("promocaoTO", modelPromocao.getTO());
		view = request.getRequestDispatcher("VisualizarPromocao.jsp");
	
		view.forward(request, response);
	}
	
	public int busca(ModelPromocao modelPromocao, ArrayList<TOPromocao> lista) {
		TOPromocao toPromocao;
		for(int i = 0; i < lista.size(); i++){
			toPromocao = lista.get(i);
			if(toPromocao.getCodPromocao() == toPromocao.getCodPromocao()){
				return i;
			}
		}
		return -1;
	}

	
}