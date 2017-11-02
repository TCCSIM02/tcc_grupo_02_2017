package Command;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Model.ModelAdministrador;
import TO.TOAdministrador;


public class AlterarAdministrador implements Command {


	@Override
	public void executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String pCodAdministrador = request.getParameter("codAdministrador");
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
		String pFlagAtivo       = request.getParameter("flagAtivo");  
		
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

		
		/*ALTERAR ESSE NULL AQUI*/
		ModelAdministrador modelAdministrador = new ModelAdministrador(pNumeroEndereco,null,pNome,pCpf,dataNasc,pEstadoCivil,pEmail,pNacionalidade,pEndereco,
				pCep,pCidade,pUf,pPais,pTel1,pTel2,pCel,pFlagAtivo,id);
		RequestDispatcher view = null;
		HttpSession session = request.getSession();
		
		modelAdministrador.alterarAdministrador();
		@SuppressWarnings("unchecked")
		ArrayList<TOAdministrador> lista = (ArrayList<TOAdministrador>)session.getAttribute("lista");
		
		int pos = busca(modelAdministrador, lista);
		lista.remove(pos);
		lista.add(pos, modelAdministrador.getTO());
		
		try {
			lista = modelAdministrador.listarAdministradores();
		} catch (ClassNotFoundException e) {			
			e.printStackTrace();
		}
		
		session.setAttribute("lista", lista);
		request.setAttribute("administradorTO", modelAdministrador.getTO());
		view = request.getRequestDispatcher("VisualizarAdministrador.jsp");
	
		view.forward(request, response);
		
	
	}
	
	public int busca(ModelAdministrador modelAdministrador, ArrayList<TOAdministrador> lista) {
		TOAdministrador toAdministrador;
		for(int i = 0; i < lista.size(); i++){
			toAdministrador = lista.get(i);
			if(toAdministrador.getCodAdministrador() == toAdministrador.getCodAdministrador()){
				return i;
			}
		}
		return -1;
	}
	
}
