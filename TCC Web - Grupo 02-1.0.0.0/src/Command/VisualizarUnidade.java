package Command;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Command.Command;
import Model.ModelUnidade;
import TO.TOUnidade;

public class VisualizarUnidade implements Command {
	
	@Override
	public void executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	       
		String pCodUnidade      = request.getParameter("id"); 
		String pCel             = request.getParameter("cel");          
		String pCep             = request.getParameter("cep");          
		String pCidade          = request.getParameter("cidade");        
		String pCnpj            = request.getParameter("cnpj");   
		String pEndereco        = request.getParameter("endereco");      
		String pFlagAtivo       = request.getParameter("flagAtivo");        
		String pNomeFantasia    = request.getParameter("nomeFantasia");    
		String pNomeRede        = request.getParameter("nomeRede");       
		String pPais            = request.getParameter("pais");
		String pNumeroEndereco  = request.getParameter("numeroEndereco");  
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
		
		Double latitude = 0.0;
		Double longitude = 0.0;
		

		ModelUnidade modelUnidade = new ModelUnidade( id, pRazaoSocial,
				pNomeFantasia,  pCnpj,  pNomeRede,  pEndereco,
				pCep,  pCidade,  pUf,
				pPais, pNumeroEndereco,  pRepresentante,  pTel1,  pTel2,
				pCel,  pFlagAtivo, null, latitude, longitude);
		RequestDispatcher view = null;
		
		try {
			modelUnidade.consultarUnidadeCod();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		request.setAttribute("unidadeTO",modelUnidade.getTO() );
		view = request.getRequestDispatcher("VisualizarUnidade.jsp");
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
