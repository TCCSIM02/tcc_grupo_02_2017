package Command;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Model.ModelAgendamento;
import TO.TOAgendamento;


public class AlterarAgendamento implements Command {

	@Override
	public void executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String pCodAgendamento = request.getParameter("codAgendamento");
		String pStatusAgendamento = request.getParameter("nomeAgendamento");
		String pDataCadastro = request.getParameter("registroAns");
		String pDataHoraComeco = request.getParameter("tipoAgendamento");
		String pFlagAtivo = request.getParameter("flagAtivo");
		String pDataHoraFim = request.getParameter("dataCadastro");
		

		
		
		int id = -1;
		try {
			id = Integer.parseInt(pCodAgendamento);
		} catch (NumberFormatException e) {

		}

		/*ALTERAR ESSE NULL AQUI*/
		ModelAgendamento modelAgendamento = new ModelAgendamento(Integer.parseInt(pCodAgendamento), 0, 0, 0, 0, 0, pFlagAtivo, null,
				null, null); 
		
		RequestDispatcher view = null;
		HttpSession session = request.getSession();
		
		modelAgendamento.alterarAgendamento();
		@SuppressWarnings("unchecked")
		ArrayList<TOAgendamento> lista = (ArrayList<TOAgendamento>)session.getAttribute("lista");
		
		int pos = busca(modelAgendamento, lista);
		lista.remove(pos);
		lista.add(pos, modelAgendamento.getTO());
		
		lista = modelAgendamento.listarAgendamentos();
		
		session.setAttribute("lista", lista);
		request.setAttribute("consultaTO", modelAgendamento.getTO());
		view = request.getRequestDispatcher("VisualizarAgendamento.jsp");
	
		view.forward(request, response);
	}
	
	public int busca(ModelAgendamento modelAgendamento, ArrayList<TOAgendamento> lista) {
		TOAgendamento toAgendamento;
		for(int i = 0; i < lista.size(); i++){
			toAgendamento = lista.get(i);
			if(toAgendamento.getCodAgendamento() == toAgendamento.getCodAgendamento()){
				return i;
			}
		}
		return -1;
	}

	
}
