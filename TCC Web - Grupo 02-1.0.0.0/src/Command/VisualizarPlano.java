package Command;

import java.io.IOException;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Command.Command;
import Model.ModelPlano;

public class VisualizarPlano implements Command {
	
	@Override
	public void executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	
		

		String pCodPlano = request.getParameter("codPlano");
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


	}

	
	

}
