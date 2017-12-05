package Command;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Model.ModelConsulta;
import Model.ModelMedico;
import Model.ModelPaciente;
import TO.TOConsulta;
import TO.TOMedico;
import TO.TOPaciente;

public class PreencheConsulta  implements Command {
	
	@Override
	public void executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		RequestDispatcher view = null;
		HttpSession session = request.getSession();
		
		String pCodMedico             =	request.getParameter("codMedico");
		String pCodPaciente           =	request.getParameter("codPaciente");
		String pCodAgendamento        =	request.getParameter("codAgendamento");
				
		
		ModelMedico modelMedico = new ModelMedico();
		ModelPaciente modelPaciente = new ModelPaciente();
		ModelConsulta modelConsulta = new ModelConsulta();
		
		ArrayList<TOMedico> listaMedico = new ArrayList<>(); 
		ArrayList<TOPaciente> listaPaciente = new ArrayList<>();
		ArrayList<TOConsulta> listaConsulta = new ArrayList<>();
		
		try {
			listaMedico = modelMedico.listarMedicosCod(pCodMedico);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			listaPaciente = modelPaciente.listarPacientesCod(pCodPaciente);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			listaConsulta = modelConsulta.listarConsultaCodAgendamento(pCodAgendamento);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		
		session.setAttribute("codAgendamento", pCodAgendamento);
		session.setAttribute("nomePaciente", listaPaciente.get(0).getNome());		
		session.setAttribute("nomeMedico", listaMedico.get(0).getNome());
		
		if(listaConsulta.isEmpty()) {		
			view = request.getRequestDispatcher("CriarConsulta.jsp");
		} else {
			session.setAttribute("diagnostico", listaConsulta.get(0).getDiagnostico());
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			SimpleDateFormat sdf2 = new SimpleDateFormat("HH:mm");
			
			
			session.setAttribute("dataComeco", sdf.format(listaConsulta.get(0).getDataHoraConsultaInicio()));	
			session.setAttribute("horaComeco", sdf2.format(listaConsulta.get(0).getDataHoraConsultaInicio()));
			session.setAttribute("dataFim", sdf.format(listaConsulta.get(0).getDataHoraConsultaFinal()));	
			session.setAttribute("horaFim", sdf2.format(listaConsulta.get(0).getDataHoraConsultaFinal()));
			session.setAttribute("exames", listaConsulta.get(0).getExames());
			session.setAttribute("receituario", listaConsulta.get(0).getReceituario());
			session.setAttribute("cid", listaConsulta.get(0).getCid());
			
			view = request.getRequestDispatcher("AlterarConsulta.jsp");
		}
		
		
		view.forward(request, response);
		
	}

}
