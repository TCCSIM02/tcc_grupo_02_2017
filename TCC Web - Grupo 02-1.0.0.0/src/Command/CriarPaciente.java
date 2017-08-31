package Command;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Model.ModelPaciente;
import TO.TOPaciente;


public class CriarPaciente implements Command {
	
	@Override
	public void executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String pNumeroEndereco 	= request.getParameter("numeroEndereco"); 	
		String pDataCadastro 	= request.getParameter("dataCadastro");	
		String pNome 			= request.getParameter("nome");	
		String pCpf 			= request.getParameter("cpf");
		String pDataNascimento 	= request.getParameter("dataNascimento");
		String pEmail			= request.getParameter("email");
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
		String pCodPaciente 	= request.getParameter("codPaciente"); 	
		String pNumConvenio 	= request.getParameter("numConvenio"); 	
		
		int id = -1;
		try {
			id = Integer.parseInt(pCodPaciente);
		} catch (NumberFormatException e) {

		}

		/*ALTERAR ESSE NULL AQUI*/
		ModelPaciente modelPaciente = new ModelPaciente(
				pNumeroEndereco, null, pNome,
				pCpf,  null,  pEstadoCivil, pEmail,
				pNacionalidade,  pLogradouro, pCep,  pCidade,
				pUf,  pPais,  pTel1,  pTel2,  pCel,
				pFlagAtivo, id,  pNumConvenio);
	
		HttpSession session = request.getSession();
		
		modelPaciente.cadastrarPaciente();
		ArrayList<TOPaciente> lista = new ArrayList<>(); 
		try {
			lista = modelPaciente.listarPacientes();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		lista.add(modelPaciente.getTO());
		
		session.setAttribute("lista", lista);		
		RequestDispatcher view = request.getRequestDispatcher("ListarPaciente.jsp");
		view.forward(request, response);
		

	}


}
