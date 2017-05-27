package Command;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Model.ModelUnidade;
import TO.TOUnidade;

public class ExcluirUnidade implements Command {
	
	@Override
	public void executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String pCel             = request.getParameter("cel");          
		String pCep             = request.getParameter("cep");          
		String pCidade          = request.getParameter("cidade");        
		String pCnpj            = request.getParameter("cnpj");       
		String pCodUnidade      = request.getParameter("codUnidade");    
		String pDataCadastro    = request.getParameter("dataCadastro");  
		String pEndereco        = request.getParameter("endereco");      
		String pFlagAtivo       = request.getParameter("flagAtivo");        
		String pNomeFantasia    = request.getParameter("nomeFantasia");    
		String pNomeRede        = request.getParameter("nomeRede");       
		String pPais            = request.getParameter("pais");           
		String pRazaoSocial     = request.getParameter("razaoSocial");     
		String pRepresentante   = request.getParameter("representante");   
		String pTel1            = request.getParameter("tel1");            
		String pTel2            = request.getParameter("tel2");           
		String pUf				= request.getParameter("uf");	
		
		int id = -1;
		try {
			id = Integer.parseInt(pCodUnidade);
		} catch (NumberFormatException e) {

		}

		/*ALTERAR ESSE NULL AQUI*/
		ModelUnidade modelUnidade = new ModelUnidade( id, pRazaoSocial,
				pNomeFantasia,  pCnpj,  pNomeRede,  pEndereco,
				pCep,  pCidade,  pUf,
				pPais,  pRepresentante,  pTel1,  pTel2,
				pCel,  pFlagAtivo, null /*new Date(pDataCadastro)*/);
		RequestDispatcher view = null;
		HttpSession session = request.getSession();
		
		modelUnidade.excluirUnidade();
		
		
		@SuppressWarnings("unchecked")
		ArrayList<TOUnidade> lista = (ArrayList<TOUnidade>)session.getAttribute("lista");
		
		lista.remove(busca(modelUnidade, lista));
		session.setAttribute("lista", lista);
		
		view = request.getRequestDispatcher("ListarUnidade.jsp");
		
		view.forward(request, response);
		
	}
	
	public int busca(ModelUnidade modelUnidade, ArrayList<TOUnidade> lista) {
		TOUnidade toUnidade;
		for(int i = 0; i < lista.size(); i++){
			toUnidade = lista.get(i);
			if(toUnidade.getCodUnidade() == modelUnidade.getCodUnidade()){
				return i;
			}
		}
		return -1;
	}


}