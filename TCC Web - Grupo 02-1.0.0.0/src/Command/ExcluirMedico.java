package Command;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Model.ModelMedico;
import TO.TOMedico;


public class ExcluirMedico implements Command {

	@Override
	public void executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String pCodMedico = request.getParameter("id");
		String pCrm = request.getParameter("crm");
		String pCro = request.getParameter("cro");
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
			id = Integer.parseInt(pCodMedico);
		} catch (NumberFormatException e) {

		}
		
		/*ALTERAR ESSE NULL AQUI*/
		ModelMedico modelMedico = new ModelMedico(pNumeroEndereco,null,pNome,pCpf,null,pEstadoCivil,pEmail,pNacionalidade,pEndereco,
				pCep,pCidade,pUf,pPais,pTel1,pTel2,pCel,pFlagAtivo,id,pCrm,pCro);
		RequestDispatcher view = null;
		HttpSession session = request.getSession();
		
		modelMedico.excluirMedico();
		
		@SuppressWarnings("unchecked")
		ArrayList<TOMedico> lista = (ArrayList<TOMedico>)session.getAttribute("lista");
				
		lista.remove(busca(modelMedico, lista));
		
		try {
			lista = modelMedico.listarMedicos();
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		}
		
		session.setAttribute("lista", lista);
		
		view = request.getRequestDispatcher("ListarMedico.jsp");
		
		view.forward(request, response);
		
	}
	
	public int busca(ModelMedico modelMedico, ArrayList<TOMedico> lista) {
		TOMedico toMedico;
		for(int i = 0; i < lista.size(); i++){
			toMedico = lista.get(i);
			if(toMedico.getCodMedico() == modelMedico.getCodMedico()){
				return i;
			}
		}
		return -1;
	}
	
}
