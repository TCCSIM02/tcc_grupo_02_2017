package Command;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import Model.ModelAgendamento;

public class ListarMedicoAgenda implements Command {

	@Override
	public void executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int medicoValor = Integer.parseInt(request.getParameter("medicoValor"));
		
		
		ModelAgendamento modelAgendamento = new ModelAgendamento(); 
			
		String lista = ""; 
		try {
			lista = modelAgendamento.listarAgendamentosMedico(medicoValor);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		String json = lista;
		PrintWriter out = response.getWriter();
		System.out.println(json);
		out.println(json);
		
		

	}
	
}
