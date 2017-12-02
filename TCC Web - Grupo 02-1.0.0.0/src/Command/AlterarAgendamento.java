package Command;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Model.ModelAgendamento;
import TO.TOAgendamento;


public class AlterarAgendamento implements Command {

	@Override
	public void executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String pCodAgendamento = request.getParameter("codAgendamento");
		String pCodPaciente = request.getParameter("codPaciente");
		String pCodUnidade = request.getParameter("codUnidade");
		String pCodMedico = request.getParameter("codMedico");
		String pCodEspecialidade = request.getParameter("codEspecialidade");
		String pFlagAtivo = request.getParameter("flagAtivo");
		
		String pDataInicio   =	request.getParameter("dataInicio");
		String pHoraInicio   =	request.getParameter("horaInicio");
		String pDataFim   =	request.getParameter("dataFim");
		String pHoraFim   =	request.getParameter("horaFim");
		
	
		String flagAtivo = "1";
		
		if (pFlagAtivo == null){
			flagAtivo = "0";
		}else{
			flagAtivo = "1";
		}
		
		int codAgendamento = -1;
		int codMedico = -1;
		int codPaciente = -1;
		int codUnidade = -1;
		int codEspecialidade = -1;
		
		try {
			codMedico = Integer.parseInt(pCodMedico);
			codPaciente = Integer.parseInt(pCodPaciente);
			codUnidade = Integer.parseInt(pCodUnidade);
			codEspecialidade = Integer.parseInt(pCodEspecialidade);
		} catch (NumberFormatException e) {

		}
		
		try {
			codAgendamento = Integer.parseInt(pCodAgendamento);
		} catch (NumberFormatException e) {

		}
		
		String dataHoraInicio = pDataInicio+" "+pHoraInicio;
		String dataHoraFim = pDataFim+" "+pHoraFim;
		
		String pattern = "dd/MM/yyyy hh:mm";
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		
		
		java.util.Date dataHoraInicioFinal = new java.util.Date();
		java.util.Date dataHoraFimFinal =  new java.util.Date();
		try {
			dataHoraInicioFinal = sdf.parse(dataHoraInicio);
			dataHoraFimFinal = sdf.parse(dataHoraFim);
			//System.out.println(dataHoraFimFinal);
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
			System.out.println("tp aq");
		}

		/*ALTERAR ESSE NULL AQUI*/
		ModelAgendamento modelAgendamento = new ModelAgendamento(codAgendamento,codPaciente, codMedico, codUnidade, 0, codEspecialidade, flagAtivo, null, dataHoraInicioFinal, dataHoraFimFinal);
				
		RequestDispatcher view = null;
		
		modelAgendamento.alterarAgendamento();

		view = request.getRequestDispatcher("Index.jsp");
	
		view.forward(request, response);
	}
	
}
