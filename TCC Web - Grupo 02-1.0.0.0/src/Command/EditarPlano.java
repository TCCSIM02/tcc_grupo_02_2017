package Command;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Model.ModelPlano;

public class EditarPlano implements Command{
	
	@Override
	public void executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		
		String pCodPlano = request.getParameter("id");
		String pNomePlano = request.getParameter("nomePlano");
		String pRegistroAns = request.getParameter("registroAns");
		String pTipoPlano = request.getParameter("tipoPlano");
		String pFlagAtivo = request.getParameter("flagAtivo");

		ArrayList<Integer> listaPlanosUnidade = new ArrayList<>();
		
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
		
		try {
			listaPlanosUnidade = modelPlano.listarPlanosUnidade(modelPlano.getCodPlano());
		} catch (Exception e) {

		}
		
		session.setAttribute("planoTO", modelPlano.getTO());
		request.setAttribute("listaPlanosUnidade", listaPlanosUnidade);
		view = request.getRequestDispatcher("AlterarPlano.jsp");
		
		view.forward(request, response);

	}

}
