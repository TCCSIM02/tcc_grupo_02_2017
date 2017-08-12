package Command;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Model.ModelAgendamento;
import TO.TOAgendamento;


public class ExcluirAgendamento implements Command{
	
	@Override
	public void executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String pCodAgendamento 		= 	request.getParameter("id");/*AJUSTADO*/
		String pValorAgendamento 		= 	request.getParameter("valorAgendamento");
		String pDescricao	 	= 	request.getParameter("descricao");
		String pResultadoAgendamento	=	request.getParameter("resultadoAgendamento");

		
		int id = -1;
	
		try {
			id = Integer.parseInt(pCodAgendamento);
		} catch (NumberFormatException e) {

		}

		/*ALTERAR ESSE NULL AQUI*/
		/*ModelAgendamento modelAgendamento = new ModelAgendamento(id, 0.0,pDescricao, pResultadoAgendamento);*/
		RequestDispatcher view = null;
		HttpSession session = request.getSession();
		
		/*modelAgendamento.excluirAgendamento();
		
		@SuppressWarnings("unchecked")
		ArrayList<TOAgendamento> lista = (ArrayList<TOAgendamento>)session.getAttribute("lista");
				
		lista.remove(busca(modelAgendamento, lista));
		
		try {
			lista = modelAgendamento.listarAgendamentos();
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		}*/
		
		//session.setAttribute("lista", lista);
		
		view = request.getRequestDispatcher("ListarAgendamento.jsp");
		
		view.forward(request, response);
		
		
	}
	
	public int busca(ModelAgendamento modelAgendamento, ArrayList<TOAgendamento> lista) {
		TOAgendamento toAgendamento;
		for(int i = 0; i < lista.size(); i++){
			toAgendamento = lista.get(i);
			if(toAgendamento.getCodAgendamento() == modelAgendamento.getCodAgendamento()){
				return i;
			}
		}
		return -1;
	}


}
