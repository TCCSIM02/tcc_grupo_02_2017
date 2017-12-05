package Command;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Model.ModelLogin;
import Model.ModelMedico;
import TO.TOMedico;

public class CriarMedico implements Command {
	
	@Override
	public void executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		/*LOGIN*/
	
		String pEmail			= request.getParameter("email");
		String pNomeLogin 		= request.getParameter("nomeLogin"); 	
		String pSenha 			= request.getParameter("senha");	
		String pCodNivel = request.getParameter("codNivel");
		
		int codNivel = -1;
		
		try {
			codNivel = Integer.parseInt(pCodNivel);
		} catch (NumberFormatException e) {
		}
		
		ModelLogin modelLogin = new ModelLogin(pNomeLogin, pEmail, pSenha, codNivel);
		try {
			modelLogin.cadastrarLogin();
		} catch (NoSuchAlgorithmException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		/*FIMLOGIN*/
		
		
		String pNumeroEndereco 	= request.getParameter("numeroEndereco"); 	
		String pNome 			= request.getParameter("nome");	
		String pCpf 			= request.getParameter("cpf");
		String pDataNascimento 	= request.getParameter("dataNascimento");	
		String pEstadoCivil		= request.getParameter("estadoCivil");
		String pNacionalidade 	= request.getParameter("nacionalidade");
		String pEndereco 		= request.getParameter("endereco");
		String pCep 			= request.getParameter("cep");
		String pCidade 			= request.getParameter("cidade");
		String pUf 				= request.getParameter("uf");				
		String pPais 			= request.getParameter("pais");			
		String pTel1 			= request.getParameter("tel1"); 			
		String pTel2 			= request.getParameter("tel2");			
		String pCel 			= request.getParameter("cel");		
		String pFlagAtivo 		= request.getParameter("flagAtivo");
		String pCodMedico 		= request.getParameter("codMedico"); 	
		String pCrm 			= request.getParameter("crm"); 
		String pCro 			= request.getParameter("cro"); 
		String[] pCheck = request.getParameterValues("check");
		
		int id = -1;
		try {
			id = Integer.parseInt(pCodMedico);
		} catch (NumberFormatException e) {
	
		}	
		
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		java.sql.Date dataNasc = null;
		try {
			dataNasc = new java.sql.Date(format.parse(pDataNascimento).getTime());
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	
		ModelMedico modelMedico = new ModelMedico(
				pNumeroEndereco, null, pNome,
				pCpf, dataNasc,  pEstadoCivil, pEmail,
				pNacionalidade,  pEndereco, pCep,  pCidade,
				pUf,  pPais,  pTel1,  pTel2,  pCel,
				pFlagAtivo, id,  pCrm, pCro); 
		
		try {
			modelMedico.codLoginCadastrado = modelLogin.getCodLoginCadastrado();
		} catch (NoSuchAlgorithmException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	
		HttpSession session = request.getSession();
		
		modelMedico.cadastrarMedico();
		
		for(int i = 0 ; i < pCheck.length ; i++ ){
			modelMedico.cadastrarMedicoEspecialidade(modelMedico.getCodMedico(), pCheck[i]);		
		}			
		ArrayList<TOMedico> lista = new ArrayList<>(); 
		try {
			lista = modelMedico.listarMedicos();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//lista.add(modelMedico.getTO());
		
		session.setAttribute("lista", lista);		
		RequestDispatcher view = request.getRequestDispatcher("ListarMedico.jsp");
		view.forward(request, response);
		
	
	}

}
