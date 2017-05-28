package Command;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Model.ModelPromocao;
import TO.TOPromocao;


public class CriarPromocao implements Command {
	
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
	
		HttpSession session = request.getSession();
		
		modelPromocao.cadastrarPromocao();
		ArrayList<TOPromocao> lista = new ArrayList<>(); 
		try {
			lista = modelPromocao.listarPromocoes();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//lista.add(modelPromocao.getTO());
		
		session.setAttribute("lista", lista);		
		RequestDispatcher view = request.getRequestDispatcher("ListarPromocao.jsp");
		view.forward(request, response);
		

	}


}
