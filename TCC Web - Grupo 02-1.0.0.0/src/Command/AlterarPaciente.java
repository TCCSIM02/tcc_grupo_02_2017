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

import Model.ModelPaciente;
import TO.TOPaciente;

public class AlterarPaciente implements Command {
	
	@Override
	public void executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String pCodPaciente = request.getParameter("codPaciente");
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
		
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		java.sql.Date dataNasc = null;
		try {
			dataNasc = new java.sql.Date(format.parse(pDataNascimento).getTime());
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		
		/*ALTERAR ESSE NULL AQUI*/
		ModelPaciente modelPaciente = new ModelPaciente(pNumeroEndereco,null,pNome,pCpf,dataNasc,pEstadoCivil,pEmail,pNacionalidade,pEndereco,
				pCep,pCidade,pUf,pPais,pTel1,pTel2,pCel,pFlagAtivo,id,pNumConvenio);
		RequestDispatcher view = null;
		HttpSession session = request.getSession();
		
		modelPaciente.alterarPaciente();
		@SuppressWarnings("unchecked")
		ArrayList<TOPaciente> lista = (ArrayList<TOPaciente>)session.getAttribute("lista");
		
		int pos = busca(modelPaciente, lista);
		lista.remove(pos);
		lista.add(pos, modelPaciente.getTO());
		
		try {
			lista = modelPaciente.listarPacientes();
		} catch (ClassNotFoundException e) {			
			e.printStackTrace();
		}
		
		session.setAttribute("lista", lista);
		request.setAttribute("pacienteTO", modelPaciente.getTO());
		view = request.getRequestDispatcher("VisualizarPaciente.jsp");
	
		view.forward(request, response);
		
	
	}
	
	public int busca(ModelPaciente modelPaciente, ArrayList<TOPaciente> lista) {
		TOPaciente toPaciente;
		for(int i = 0; i < lista.size(); i++){
			toPaciente = lista.get(i);
			if(toPaciente.getCodPaciente() == toPaciente.getCodPaciente()){
				return i;
			}
		}
		return -1;
	}
	
	

}
