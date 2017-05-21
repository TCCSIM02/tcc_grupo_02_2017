package Command;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Model.ModelPlano;

public class EditarPlano implements Command{
	
	@Override
	public void executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String pCodPlano = request.getParameter("id");
		String pNomePlano = request.getParameter("nomePlano");
		String pRegistroAns = request.getParameter("registroAns");
		String pTipoPlano = request.getParameter("tipoPlano");
		String pFlagAtivo = request.getParameter("flagAtivo");
		String pDataCadastro = request.getParameter("dataCadastro");

		int id = -1;
		try {
			id = Integer.parseInt(pCodPlano);
		} catch (NumberFormatException e) {

		}

		/*ALTERAR ESSE NULL AQUI*/
		ModelPlano modelPlano = new ModelPlano(id,pNomePlano,pRegistroAns,pTipoPlano, pFlagAtivo, null);
		RequestDispatcher view = null;
		
		try {
			modelPlano.consultarPlanoCod();
		} catch (ClassNotFoundException e) {
		
			e.printStackTrace();
		}
			
		request.setAttribute("planoTO", modelPlano.getTO());
		view = request.getRequestDispatcher("AlterarPlano.jsp");
		
		view.forward(request, response);

	}

}
