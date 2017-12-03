package Command;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Model.ModelConsulta;
import TO.TOConsulta;

public class ExcluirConsulta implements Command {
	
	@Override
	public void executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String pCodConsulta             =	request.getParameter("id");             
		
		int id = -1;
		
		try {
			id = Integer.parseInt(pCodConsulta);
		} catch (NumberFormatException e) {

		}

		ModelConsulta modelConsulta = new ModelConsulta(id);
		RequestDispatcher view = null;
		HttpSession session = request.getSession();
		
		modelConsulta.excluirConsulta();
		
		@SuppressWarnings("unchecked")
		ArrayList<TOConsulta> lista = (ArrayList<TOConsulta>)session.getAttribute("lista");
				
		lista.remove(busca(modelConsulta, lista));
		
		try {
			lista = modelConsulta.listarConsultas();
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		}
		
		session.setAttribute("lista", lista);
		
		view = request.getRequestDispatcher("ListarConsulta.jsp");
		
		view.forward(request, response);
		
		
	}
	
	public int busca(ModelConsulta modelConsulta, ArrayList<TOConsulta> lista) {
		TOConsulta toConsulta;
		for(int i = 0; i < lista.size(); i++){
			toConsulta = lista.get(i);
			if(toConsulta.getCodConsulta() == modelConsulta.getCodConsulta()){
				return i;
			}
		}
		return -1;
	}


}
