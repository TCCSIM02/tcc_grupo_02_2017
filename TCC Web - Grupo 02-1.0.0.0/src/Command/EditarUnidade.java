package Command;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.ModelUnidade;

public class EditarUnidade implements Command{
	
	@Override
	public void executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	       
		String pCodUnidade      = request.getParameter("id");    
		String pCel             = request.getParameter("cel");          
		String pCep             = request.getParameter("cep");          
		String pCidade          = request.getParameter("cidade");        
		String pCnpj            = request.getParameter("cnpj");
		String pDataCadastro    = request.getParameter("dataCadastro");  
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
		String pLatitude		= request.getParameter("latitude");
		String pLongitude		= request.getParameter("longitude");
		
		Double latitude = 0.0;
		Double longitude = 0.0;
		
		/*try {
			latitude = Double.parseDouble(pLatitude);
			longitude = Double.parseDouble(pLongitude);
		} catch (NumberFormatException e){
						
		}*/

		int id = -1;
		try {
			id = Integer.parseInt(pCodUnidade);
		} catch (NumberFormatException e) {

		}

		/*ALTERAR ESSE NULL AQUI*/
		ModelUnidade modelUnidade = new ModelUnidade( id, pRazaoSocial,
				pNomeFantasia,  pCnpj,  pNomeRede,  pEndereco,
				pCep,  pCidade,  pUf,
				pPais, pNumeroEndereco,  pRepresentante,  pTel1,  pTel2,
				pCel,  pFlagAtivo, null /*new Date(pDataCadastro)*/, latitude, longitude);;
		RequestDispatcher view = null;
		
		try {
			modelUnidade.consultarUnidadeCod();
		} catch (ClassNotFoundException e) {
		
			e.printStackTrace();
		}
			
		request.setAttribute("unidadeTO", modelUnidade.getTO());
		view = request.getRequestDispatcher("AlterarUnidade.jsp");
		
		view.forward(request, response);

	}

}
