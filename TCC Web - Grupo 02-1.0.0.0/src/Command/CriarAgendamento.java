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


public class CriarAgendamento implements Command {
	
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
		ModelAgendamento modelAgendamento = new ModelAgendamento(Integer.parseInt(pCodAgendamento), pStatusAgendamento, pFlagAtivo, null,
				null, null);
	
		HttpSession session = request.getSession();
		
		modelAgendamento.cadastrarAgendamento();
		ArrayList<TOAgendamento> lista = new ArrayList<>(); 
		lista = modelAgendamento.listarAgendamentos();
		
		session.setAttribute("lista", lista);		
		RequestDispatcher view = request.getRequestDispatcher("ListarAgendamento.jsp");
		view.forward(request, response);
	}
}