package Command;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import Model.ModelMedico;
import Model.ModelUnidade;
import TO.TOMedico;
import TO.TOUnidade;

public class ListarUnidadePlano implements Command {

	@Override
	public void executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		//String especialidadeValor = request.getParameter("especialidadeValor");
		String pacienteValor = request.getParameter("pacienteValor");
	
		ModelUnidade modelUnidade = new ModelUnidade(); 
		
		ArrayList<TOUnidade> lista = new ArrayList<>(); 
		try {
			lista = modelUnidade.listarUnidadePlano(pacienteValor);
			//lista = modelMedico.listarMedicos(especialidadeValor);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		
		Gson novo = new Gson();
		String json = novo.toJson(lista);
		PrintWriter out = response.getWriter();
		System.out.println(json);
		out.println(json);
		
		

	}
	
}
