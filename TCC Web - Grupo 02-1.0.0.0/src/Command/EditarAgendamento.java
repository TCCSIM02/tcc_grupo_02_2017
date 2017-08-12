package Command;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Model.ModelAgendamento;

public class EditarAgendamento implements Command{
	
	@Override
	public void executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String pCodAgendamento             =	request.getParameter("id");             
		String pDataHoraAgendamentoFinal   =	request.getParameter("dataHoraAgendamentoFinal");   
		String pDataHoraAgendamentoInicio  =	request.getParameter("dataHoraAgendamentoInicio");  
		String pDiagnostico             =	request.getParameter("diagnostico");             
		String pStatusAgendamento          =	request.getParameter("statusAgendamento");          
		String pValorAgendamento			=	request.getParameter("valorAgendamento");	
		
		
		System.out.println("Cod: " + pCodAgendamento);
		System.out.println("id: " + request.getParameter("id"));
		
		int id = -1;
		try {
			id = Integer.parseInt(pCodAgendamento);
		} catch (NumberFormatException e) {

		}

		/*ALTERAR ESSE NULL AQUI*/
		ModelAgendamento modelAgendamento = new ModelAgendamento(id);
		RequestDispatcher view = null;
		
		modelAgendamento.consultarAgendamentoCod();
			
		request.setAttribute("consultaTO", modelAgendamento.getTO());
		view = request.getRequestDispatcher("AlterarAgendamento.jsp");
		
		view.forward(request, response);

	}

}
