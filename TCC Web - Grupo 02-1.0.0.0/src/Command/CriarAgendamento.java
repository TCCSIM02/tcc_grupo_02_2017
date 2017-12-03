package Command;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Model.ModelAgendamento;
import TO.TOAgendamento;


public class CriarAgendamento implements Command {
	
	@Override
	public void executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String pCodPaciente = request.getParameter("codPaciente");
		String pCodUnidade = request.getParameter("codUnidade");
		String pCodMedico = request.getParameter("codMedico");
		String pCodEspecialidade = request.getParameter("codEspecialidade");
		
		String pDataInicio   =	request.getParameter("dataInicio");
		String pHoraInicio   =	request.getParameter("horaInicio");
		String pDataFim   =	request.getParameter("dataFim");
		String pHoraFim   =	request.getParameter("horaFim");
		
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
		
		String dataHoraInicio = pDataInicio+" "+pHoraInicio;
		String dataHoraFim = pDataFim+" "+pHoraFim;
		
		String pattern = "dd/MM/yyyy hh:mm:ss";
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		
		
		java.util.Date dataHoraInicioFinal = new java.util.Date();
		java.util.Date dataHoraFimFinal =  new java.util.Date();
		try {
			dataHoraInicioFinal = sdf.parse(dataHoraInicio);
			dataHoraFimFinal = sdf.parse(dataHoraFim);
		} catch (ParseException e1) {
			e1.printStackTrace();
		}	

		ModelAgendamento modelAgendamento = new ModelAgendamento(-1,codPaciente, codMedico, codUnidade, 0, codEspecialidade, null, null, dataHoraInicioFinal, dataHoraFimFinal);
	
		HttpSession session = request.getSession();
		
		modelAgendamento.cadastrarAgendamento();
		ArrayList<TOAgendamento> lista = new ArrayList<>(); 

		
		session.setAttribute("lista", lista);		
		RequestDispatcher view = request.getRequestDispatcher("Index.jsp");
		view.forward(request, response);
	}
}
