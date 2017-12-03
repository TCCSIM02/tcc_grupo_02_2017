package Command;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Command.Command;
import Model.ModelPlano;
import TO.TOPlano;

public class VisualizarPlano implements Command {
	
	@Override
	public void executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String pCodPlano = request.getParameter("id");
		String pNomePlano = request.getParameter("nomePlano");
		String pRegistroAns = request.getParameter("registroAns");
		String pTipoPlano = request.getParameter("tipoPlano");
		String pFlagAtivo = request.getParameter("flagAtivo");

		int id = -1;
		try {
			id = Integer.parseInt(pCodPlano);
		} catch (NumberFormatException e) {

		}

		ModelPlano modelPlano = new ModelPlano(id,pNomePlano,pRegistroAns,pTipoPlano, pFlagAtivo, null);
		RequestDispatcher view = null;
		
		try {
			modelPlano.consultarPlanoCod();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		request.setAttribute("planoTO",modelPlano.getTO() );
		view = request.getRequestDispatcher("VisualizarPlano.jsp");
		view.forward(request, response);

	}
	
	public int busca(ModelPlano modelPlano, ArrayList<TOPlano> lista) {
		TOPlano toPlano;
		for(int i = 0; i < lista.size(); i++){
			toPlano = lista.get(i);
			if(toPlano.getCodPlano() == modelPlano.getCodPlano()){
				return i;
			}
		}
		return -1;
	}

	
	

}
