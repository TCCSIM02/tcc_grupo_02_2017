package Command;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import Model.ModelAgendamento;
import TO.TOAgendamento;

public class ListarMedicoAgenda implements Command {

	@Override
	public void executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		//String especialidadeValor = request.getParameter("especialidadeValor");
		String medicoValor = request.getParameter("medicoValor");
		
		
		ModelAgendamento modelAgendamento = new ModelAgendamento(); 
			
		String lista = ""; 
		try {
			lista = modelAgendamento.listarAgendamentosMedico(medicoValor);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//lista = modelMedico.listarMedicos(especialidadeValor);		
		
		
		//Gson novo = new Gson();
		//String json = novo.toJson(lista);
		String json = lista;
		PrintWriter out = response.getWriter();
		System.out.println(json);
		out.println(json);
		
		

	}
	
}
