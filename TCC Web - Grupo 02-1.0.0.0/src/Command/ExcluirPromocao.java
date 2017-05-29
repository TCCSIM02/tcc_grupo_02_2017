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

public class ExcluirPromocao implements Command {
	
	@Override
	public void executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String pCodPromocao		=	request.getParameter("id");             
		String pDataCadastro    =	request.getParameter("dataCadastro");   
		String pDataInicio      =	request.getParameter("dataInicio");  
		String pDataTermino     =	request.getParameter("dataTermino");             
		String pFlagAtivo       =	request.getParameter("flagAtivo");          
		String pValorPromocao   =	request.getParameter("valorPromocao");

		int id = -1;
		System.out.println("id: "+pCodPromocao );
		
		try {
			id = Integer.parseInt(pCodPromocao);
		} catch (NumberFormatException e) {

		}

		/*ALTERAR ESSE NULL AQUI*/
		ModelPromocao modelPromocao = new ModelPromocao(id);
		RequestDispatcher view = null;
		HttpSession session = request.getSession();
		
		modelPromocao.excluirPromocao();
		
		@SuppressWarnings("unchecked")
		ArrayList<TOPromocao> lista = (ArrayList<TOPromocao>)session.getAttribute("lista");
				
		lista.remove(busca(modelPromocao, lista));
		
		try {
			lista = modelPromocao.listarPromocoes();
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		}
		
		session.setAttribute("lista", lista);
		
		view = request.getRequestDispatcher("ListarPromocao.jsp");
		
		view.forward(request, response);
		
		
	}
	
	public int busca(ModelPromocao modelPromocao, ArrayList<TOPromocao> lista) {
		TOPromocao toPromocao;
		for(int i = 0; i < lista.size(); i++){
			toPromocao = lista.get(i);
			if(toPromocao.getCodPromocao() == modelPromocao.getCodPromocao()){
				return i;
			}
		}
		return -1;
	}


}
