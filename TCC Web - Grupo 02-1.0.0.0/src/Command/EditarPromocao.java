package Command;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.ModelPromocao;

public class EditarPromocao implements Command{
	
	@Override
	public void executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String pCodPromocao		=	request.getParameter("id");    /*Alterado*/         
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

		System.out.println("id: "+ pCodPromocao);
		System.out.println("id: "+ request.getParameter("id"));		
		
		/*ALTERAR ESSE NULL AQUI*/
		ModelPromocao modelPromocao = new ModelPromocao(id);
		
		RequestDispatcher view = null;
		
		try {
			modelPromocao.consultarPromocaoCod();
		} catch (ClassNotFoundException e) {
		
			e.printStackTrace();
		}
			
		request.setAttribute("promocaoTO", modelPromocao.getTO());
		view = request.getRequestDispatcher("AlterarPromocao.jsp");
		
		view.forward(request, response);

	}

}
