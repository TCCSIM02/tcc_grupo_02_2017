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

import Model.ModelMedico;
import TO.TOMedico;

public class AlterarMedico implements Command {

	@Override
	public void executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String pCodMedico = request.getParameter("codMedico");
		String pCodUnidade = request.getParameter("codUnidade");
		String pCrm = request.getParameter("crm");
		String pCro = request.getParameter("cro");
		String pNumeroEndereco = request.getParameter("numeroEndereco");
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
			id = Integer.parseInt(pCodMedico);
		} catch (NumberFormatException e) {

		}
		
		int codUnidade = -1;
		try {
			codUnidade = Integer.parseInt(pCodUnidade);
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

		ModelMedico modelMedico = new ModelMedico(pNumeroEndereco,null,pNome,pCpf,dataNasc,pEstadoCivil,pEmail,pNacionalidade,pEndereco,
				pCep,pCidade,pUf,pPais,pTel1,pTel2,pCel,pFlagAtivo,id, codUnidade, pCrm, pCro);
		RequestDispatcher view = null; 
		HttpSession session = request.getSession();
		
		modelMedico.alterarMedico();
		@SuppressWarnings("unchecked")
		ArrayList<TOMedico> lista = (ArrayList<TOMedico>)session.getAttribute("lista");
		
		int pos = busca(modelMedico, lista);
		lista.remove(pos);
		lista.add(pos, modelMedico.getTO());
		
		try {
			lista = modelMedico.listarMedicos();
		} catch (ClassNotFoundException e) {			
			e.printStackTrace();
		}
		
		session.setAttribute("lista", lista);
		request.setAttribute("medicoTO", modelMedico.getTO());
		view = request.getRequestDispatcher("VisualizarMedico.jsp");
	
		view.forward(request, response);
		
	
	}
	
	public int busca(ModelMedico modelMedico, ArrayList<TOMedico> lista) {
		TOMedico toMedico;
		for(int i = 0; i < lista.size(); i++){
			toMedico = lista.get(i);
			if(toMedico.getCodMedico() == toMedico.getCodMedico()){
				return i;
			}
		}
		return -1;
	}
	
}
