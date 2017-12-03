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

import Model.ModelAdministrador;
import Model.ModelLogin;
import TO.TOAdministrador;

public class CriarAdministrador implements Command {

	@Override
	public void executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*LOGIN*/
		
		String pEmail			= request.getParameter("email");
		String pNomeLogin 		= request.getParameter("nomeLogin"); 	
		String pSenha 			= request.getParameter("senha");	
		
		ModelLogin modelLogin = new ModelLogin(pNomeLogin, pEmail, pSenha);
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
		String pLogradouro 		= request.getParameter("endereco");
		String pCep 			= request.getParameter("cep");
		String pCidade 			= request.getParameter("cidade");
		String pUf 				= request.getParameter("uf");				
		String pPais 			= request.getParameter("pais");			
		String pTel1 			= request.getParameter("tel1"); 			
		String pTel2 			= request.getParameter("tel2");			
		String pCel 			= request.getParameter("cel");		
		String pFlagAtivo 		= request.getParameter("flagAtivo");
		String pCodAdministrador 	= request.getParameter("codAdministrador"); 
		
		int id = -1;
		try {
			id = Integer.parseInt(pCodAdministrador);
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

		ModelAdministrador modelAdministrador = new ModelAdministrador(
				pNumeroEndereco, null, pNome,
				pCpf, dataNasc,  pEstadoCivil, pEmail,
				pNacionalidade,  pLogradouro, pCep,  pCidade,
				pUf,  pPais,  pTel1,  pTel2,  pCel,
				pFlagAtivo, id); 
		
		try {
			modelAdministrador.codLoginCadastrado = modelLogin.getCodLoginCadastrado();
		} catch (NoSuchAlgorithmException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	
		HttpSession session = request.getSession();
		
		modelAdministrador.cadastrarAdministrador();
		ArrayList<TOAdministrador> lista = new ArrayList<>(); 
		try {
			lista = modelAdministrador.listarAdministradores();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		session.setAttribute("lista", lista);		
		RequestDispatcher view = request.getRequestDispatcher("ListarAdministrador.jsp");
		view.forward(request, response);
		

	}
	
}
