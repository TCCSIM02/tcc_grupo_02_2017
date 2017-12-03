package Command;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.ModelMedico;


public class EditarMedico implements Command {
	
	@Override
	public void executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String pCodMedico = request.getParameter("id");
		String pCrm = request.getParameter("crm");
		String pCro = request.getParameter("cro");
		String pNumeroEndereco = request.getParameter("numeroEndereco");
		String pNome = request.getParameter("nome");
		String pCpf = request.getParameter("cpf");
		String pEstadoCivil = request.getParameter("estadoCivil");
		String pEmail = request.getParameter("email");
		String pNacionalidade = request.getParameter("nacionalidade");
		String pEndereco = request.getParameter("endereco");
		String pCep = request.getParameter("cep");
		String pCidade = request.getParameter("cidade");
		String pUf = request.getParameter("uf");
		String pPais = request.getParameter("pais");
		String pTel1 = request.getParameter("tel1");
		String pTel2 = request.getParameter("tel2");
		String pCel = request.getParameter("cel");
		String pFlagAtivo = request.getParameter("flagAtivo");
		
		int id = -1;
		try {
			id = Integer.parseInt(pCodMedico);
		} catch (NumberFormatException e) {

		}
		
		ModelMedico modelMedico = new ModelMedico(pNumeroEndereco,null,pNome,pCpf,null,pEstadoCivil,pEmail,pNacionalidade,pEndereco,
				pCep,pCidade,pUf,pPais,pTel1,pTel2,pCel,pFlagAtivo,id,pCrm, pCro);
		RequestDispatcher view = null;
		
		try {
			modelMedico.consultarMedicoCod();
			
		} catch (ClassNotFoundException e) {
		
			e.printStackTrace();
		}
			
		request.setAttribute("medicoTO", modelMedico.getTO());
		view = request.getRequestDispatcher("AlterarMedico.jsp");
		
		view.forward(request, response);
		
	}

}
