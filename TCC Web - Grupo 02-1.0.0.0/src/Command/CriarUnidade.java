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

public class CriarUnidade implements Command{
	
	@Override
	public void executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String pCel             = request.getParameter("cel");          
		String pCep             = request.getParameter("cep");          
		String pCidade          = request.getParameter("cidade");        
		String pCnpj            = request.getParameter("cnpj");       
		String pCodUnidade      = request.getParameter("codUnidade");   
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
		
		int id = -1;
		try {
			id = Integer.parseInt(pCodUnidade);
		} catch (NumberFormatException e) {

		}
		
		Double latitude = 0.0;
		Double longitude = 0.0;
		
		try {
			latitude = Double.parseDouble(pLatitude);
			longitude = Double.parseDouble(pLongitude);
		} catch (NumberFormatException e){
			
		}

		ModelUnidade modelUnidade = new ModelUnidade( id, pRazaoSocial,
				pNomeFantasia,  pCnpj,  pNomeRede,  pEndereco,
				pCep,  pCidade,  pUf,
				pPais, pNumeroEndereco,  pRepresentante,  pTel1,  pTel2,
				pCel,  pFlagAtivo, null, latitude, longitude);
	
		HttpSession session = request.getSession();
		
		modelUnidade.cadastrarUnidade();
		ArrayList<TOUnidade> lista = new ArrayList<>();
		lista.add(modelUnidade.getTO());
		
		try {
			lista = modelUnidade.listarUnidades();
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		}
		
		session.setAttribute("lista", lista);
		RequestDispatcher view = request.getRequestDispatcher("ListarUnidade.jsp");
		view.forward(request, response);
	}

}
