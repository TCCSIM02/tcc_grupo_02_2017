package Command;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.ModelPaciente;
import TO.TOPaciente;

public class VisualizarPaciente implements Command {

	
	@Override
	public void executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String pCodPaciente = request.getParameter("id");
		String pNumConvenio = request.getParameter("numConvenio");
		String pNumeroEndereco = request.getParameter("numeroEndereco");
		String pDataCadastro = request.getParameter("dataCadastro");
		String pNome = request.getParameter("nome");
		String pCpf = request.getParameter("cpf");
		String pDataNascimento = request.getParameter("dataNascimento");
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
			id = Integer.parseInt(pCodPaciente);
		} catch (NumberFormatException e) {

		}
		
		/*ALTERAR ESSE NULL AQUI*/
		ModelPaciente modelPaciente = new ModelPaciente(pNumeroEndereco,null,pNome,pCpf,null,pEstadoCivil,pEmail,pNacionalidade,pEndereco,
				pCep,pCidade,pUf,pPais,pTel1,pTel2,pCel,pFlagAtivo,id,pNumConvenio);
		RequestDispatcher view = null;
		
		try {
			modelPaciente.consultarPacienteCod();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		request.setAttribute("pacienteTO",modelPaciente.getTO() );
		view = request.getRequestDispatcher("VisualizarPaciente.jsp");
		view.forward(request, response);
		
	}
	
	
	public int busca(ModelPaciente modelPaciente, ArrayList<TOPaciente> lista) {
		TOPaciente toPaciente;
		for(int i = 0; i < lista.size(); i++){
			toPaciente = lista.get(i);
			if(toPaciente.getCodPaciente() == modelPaciente.getCodPaciente()){
				return i;
			}
		}
		return -1;
	}
}
