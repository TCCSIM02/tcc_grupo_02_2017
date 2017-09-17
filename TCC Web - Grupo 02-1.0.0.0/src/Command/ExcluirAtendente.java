package Command;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Model.ModelAtendente;
import TO.TOAtendente;


public class ExcluirAtendente implements Command{

	@Override
	public void executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String pCodAtendente = request.getParameter("id");
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
			id = Integer.parseInt(pCodAtendente);
		} catch (NumberFormatException e) {

		}
		
		/*ALTERAR ESSE NULL AQUI*/
		ModelAtendente modelAtendente = new ModelAtendente(pNumeroEndereco,null,pNome,pCpf,null,pEstadoCivil,pEmail,pNacionalidade,pEndereco,
				pCep,pCidade,pUf,pPais,pTel1,pTel2,pCel,pFlagAtivo,id);
		RequestDispatcher view = null;
		HttpSession session = request.getSession();
		
		modelAtendente.excluirAtendente();
		
		@SuppressWarnings("unchecked")
		ArrayList<TOAtendente> lista = (ArrayList<TOAtendente>)session.getAttribute("lista");
				
		lista.remove(busca(modelAtendente, lista));
		
		try {
			lista = modelAtendente.listarAtendentes();
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		}
		
		session.setAttribute("lista", lista);
		
		view = request.getRequestDispatcher("ListarAtendente.jsp");
		
		view.forward(request, response);
		
	}
	
	public int busca(ModelAtendente modelAtendente, ArrayList<TOAtendente> lista) {
		TOAtendente toAtendente;
		for(int i = 0; i < lista.size(); i++){
			toAtendente = lista.get(i);
			if(toAtendente.getCodAtendente() == modelAtendente.getCodAtendente()){
				return i;
			}
		}
		return -1;
	}
	
}
