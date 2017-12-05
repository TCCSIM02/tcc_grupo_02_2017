package Command;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Model.ModelPlano;
import TO.TOPlano;


public class CriarPlano implements Command {
	
	@Override
	public void executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


		String pCodPlano = request.getParameter("codPlano");
		String pNomePlano = request.getParameter("nomePlano");
		String pRegistroAns = request.getParameter("registroAns");
		String pTipoPlano = request.getParameter("tipoPlano");
		String pFlagAtivo = request.getParameter("flagAtivo");
		String[] pCheck = request.getParameterValues("check");
		
		int id = -1;
		try {
			id = Integer.parseInt(pCodPlano);
		} catch (NumberFormatException e) {

		}

		ModelPlano modelPlano = new ModelPlano(id,pNomePlano,pRegistroAns,pTipoPlano, pFlagAtivo, null);
	
		HttpSession session = request.getSession();
		
		modelPlano.cadastrarPlano();
		
		if (pCheck != null){
				
			for(int i = 0 ; i < pCheck.length ; i++ ){
				modelPlano.cadastrarPlanoUnidade(modelPlano.getCodPlano(), pCheck[i]);		
			}
		
		}
		
		ArrayList<TOPlano> lista = new ArrayList<>(); 
		
		try {
			lista = modelPlano.listarPlanos();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//lista.add(modelPlano.getTO());
		
		session.setAttribute("lista", lista);		
		RequestDispatcher view = request.getRequestDispatcher("ListarPlano.jsp");
		view.forward(request, response);
		

	}


}
