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

import Model.ModelConsulta;
import TO.TOConsulta;


public class CriarConsulta implements Command {
	
	@Override
	public void executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
 
		String pCodAgendamento          =	request.getParameter("codAgendamento");  
		String pDiagnostico             =	request.getParameter("diagnostico");		
		String pDataInicio   =	request.getParameter("dataInicio");
		String pHoraInicio   =	request.getParameter("horaInicio");
		String pDataFim   =	request.getParameter("dataFim");
		String pHoraFim   =	request.getParameter("horaFim");
		String pExames = request.getParameter("exames");
		String pReceituario = request.getParameter("receituario");

		int codAgendamento = -1;
		
		try {
			codAgendamento = Integer.parseInt(pCodAgendamento);
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
			System.out.println(dataHoraFimFinal);
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}	
		
		/*ALTERAR ESSE NULL AQUI*/
		ModelConsulta modelConsulta = new ModelConsulta(-1, codAgendamento, dataHoraInicioFinal , dataHoraFimFinal,  pDiagnostico, pExames, pReceituario);
	
		HttpSession session = request.getSession();
		
		modelConsulta.cadastrarConsulta();
		ArrayList<TOConsulta> lista = new ArrayList<>(); 
		try {
			lista = modelConsulta.listarConsultas();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//lista.add(modelConsulta.getTO());
		
		session.setAttribute("lista", lista);		
		RequestDispatcher view = request.getRequestDispatcher("ListarConsultasMedico.jsp");
		view.forward(request, response);
	}
}
