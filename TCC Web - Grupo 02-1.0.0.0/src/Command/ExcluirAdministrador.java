package Command;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Model.ModelAdministrador;
import TO.TOAdministrador;


public class ExcluirAdministrador implements Command {


	@Override
	public void executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String pCodAdministrador = request.getParameter("id");
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
			id = Integer.parseInt(pCodAdministrador);
		} catch (NumberFormatException e) {

		}

		ModelAdministrador modelAdministrador = new ModelAdministrador(pNumeroEndereco,null,pNome,pCpf,null,pEstadoCivil,pEmail,pNacionalidade,pEndereco,
				pCep,pCidade,pUf,pPais,pTel1,pTel2,pCel,pFlagAtivo,id);
		RequestDispatcher view = null;
		HttpSession session = request.getSession();
		
		modelAdministrador.excluirAdministrador();
		
		@SuppressWarnings("unchecked")
		ArrayList<TOAdministrador> lista = (ArrayList<TOAdministrador>)session.getAttribute("lista");
				
		lista.remove(busca(modelAdministrador, lista));
		
		try {
			lista = modelAdministrador.listarAdministradores();
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		}
		
		session.setAttribute("lista", lista);
		
		view = request.getRequestDispatcher("ListarAdministrador.jsp");
		
		view.forward(request, response);
		
	}
	
	public int busca(ModelAdministrador modelAdministrador, ArrayList<TOAdministrador> lista) {
		TOAdministrador toAdministrador;
		for(int i = 0; i < lista.size(); i++){
			toAdministrador = lista.get(i);
			if(toAdministrador.getCodAdministrador() == modelAdministrador.getCodAdministrador()){
				return i;
			}
		}
		return -1;
	}
	
	
}
