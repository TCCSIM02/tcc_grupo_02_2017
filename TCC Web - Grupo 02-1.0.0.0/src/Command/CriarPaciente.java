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
import Model.ModelPaciente;
import TO.TOPaciente;


public class CriarPaciente implements Command {
	
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
		String pEndereco 		= request.getParameter("endereco");
		String pCep 			= request.getParameter("cep");
		String pCidade 			= request.getParameter("cidade");
		String pUf 				= request.getParameter("uf");				
		String pPais 			= request.getParameter("pais");			
		String pTel1 			= request.getParameter("tel1"); 			
		String pTel2 			= request.getParameter("tel2");			
		String pCel 			= request.getParameter("cel");		
		String pFlagAtivo 		= request.getParameter("flagAtivo");
		String pCodPaciente 	= request.getParameter("codPaciente"); 	
		String pNumConvenio 	= request.getParameter("numConvenio"); 
		String pAlergiaMedicamento = request.getParameter("alergiaMedicamento");
		String pAlergiaAlimentares = request.getParameter("alergiaAlimentares");
		String pPeso = request.getParameter("peso");
		String pAltura = request.getParameter("altura");
		String pMedicamentoContinuo = request.getParameter("medicamentoContinuo");
		String pCirurgia = request.getParameter("cirurgia");
		String pAntecedentesPessoais = request.getParameter("antecedentesPessoais");
		String pTipoSanguineo = request.getParameter("tipoSanguineo");
		
		int id = -1;
		Double peso = 0.0;
		Double altura = 0.0;
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		java.sql.Date dataNasc = null;		
		
		try {
			id = Integer.parseInt(pCodPaciente);
		} catch (NumberFormatException e) {
		}	
		
		try {
			peso = Double.parseDouble(pPeso);
			altura = Double.parseDouble(pAltura);
		} catch (NumberFormatException e) {
		}	
		
		try {
			dataNasc = new java.sql.Date(format.parse(pDataNascimento).getTime());
		} catch (ParseException e1) {
		}

		ModelPaciente modelPaciente = new ModelPaciente(pNumeroEndereco,null,pNome,pCpf,dataNasc,
				pEstadoCivil,pEmail,pNacionalidade,pEndereco,
				pCep,pCidade,pUf,pPais,pTel1,pTel2,pCel,pFlagAtivo,id,pNumConvenio,
				pAlergiaMedicamento, pAlergiaAlimentares, pMedicamentoContinuo,
				pCirurgia, pAntecedentesPessoais, pTipoSanguineo, peso, altura);
		
		try {
			modelPaciente.codLoginCadastrado = modelLogin.getCodLoginCadastrado();
		} catch (NoSuchAlgorithmException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	
		HttpSession session = request.getSession();
		
		modelPaciente.cadastrarPaciente();
		ArrayList<TOPaciente> lista = new ArrayList<>(); 
		try {
			lista = modelPaciente.listarPacientes();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//lista.add(modelPaciente.getTO());
		
		session.setAttribute("lista", lista);		
		RequestDispatcher view = request.getRequestDispatcher("ListarPaciente.jsp");
		view.forward(request, response);
		

	}


}
