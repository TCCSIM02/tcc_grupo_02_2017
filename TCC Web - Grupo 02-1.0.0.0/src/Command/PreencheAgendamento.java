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
import Model.ModelEspecialidade;
import Model.ModelMedico;
import Model.ModelPaciente;
import Model.ModelUnidade;
import TO.TOAgendamento;
import TO.TOEspecialidade;
import TO.TOMedico;
import TO.TOPaciente;
import TO.TOUnidade;

public class PreencheAgendamento  implements Command {
	
	@Override
	public void executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		RequestDispatcher view = null;
		HttpSession session = request.getSession();

		String pAgendamentoValor =	request.getParameter("agendamentoValor");
		String pPacienteValor =	request.getParameter("pacienteValor");
		String pEspecialidadeValor =	request.getParameter("especialidadeValor");
		String pUnidadeValor =	request.getParameter("unidadeValor");
		String pMedicoValor =	request.getParameter("medicoValor");
				
		
		ModelAgendamento modelAgendamento = new ModelAgendamento();
		ModelMedico modelMedico = new ModelMedico();
		ModelPaciente modelPaciente = new ModelPaciente();
		ModelEspecialidade modelEspecialidade = new ModelEspecialidade();
		ModelUnidade modelUnidade= new ModelUnidade();
		
		ArrayList<TOAgendamento> listaAgendamento = new ArrayList<>(); 
		ArrayList<TOMedico> listaMedico = new ArrayList<>(); 
		ArrayList<TOPaciente> listaPaciente = new ArrayList<>();
		ArrayList<TOEspecialidade> listaEspecialidade = new ArrayList<>();
		ArrayList<TOUnidade> listaUnidade = new ArrayList<>();

		try {
			listaMedico = modelMedico.listarMedicosCod(pMedicoValor);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			listaPaciente = modelPaciente.listarPacientesCod(pPacienteValor);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			listaEspecialidade = modelEspecialidade.listarEspecialidadesCod(pEspecialidadeValor);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			listaUnidade = modelUnidade.listarUnidadeCod(pUnidadeValor);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	

		
		session.setAttribute("nomePaciente", listaPaciente.get(0).getNome());	
		session.setAttribute("codPaciente", listaPaciente.get(0).getCodPaciente());	
		
		session.setAttribute("nomeMedico", listaMedico.get(0).getNome());
		session.setAttribute("codMedico", listaMedico.get(0).getCodMedico());
		
		session.setAttribute("nomeEspecialidade", listaEspecialidade.get(0).getEspecialidade());
		session.setAttribute("codEspecialidade", listaEspecialidade.get(0).getCodEspecialidade());
		
		session.setAttribute("nomeUnidade", listaUnidade.get(0).getNomeFantasia());
		session.setAttribute("codUnidade", listaUnidade.get(0).getCodUnidade());
		
		
		if (pAgendamentoValor.equals("undefined")){
			view = request.getRequestDispatcher("CriarAgendamento.jsp");
		} else {
			
			try {
				listaAgendamento = modelAgendamento.listarAgendamentosCod(pAgendamentoValor);
			} catch (ClassNotFoundException | ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			SimpleDateFormat sdf2 = new SimpleDateFormat("HH:mm");
			
			session.setAttribute("codAgendamento", listaAgendamento.get(0).getCodAgendamento());
			
			session.setAttribute("flagAtivo", listaAgendamento.get(0).getFlagAtivo());
			
			session.setAttribute("dataComeco", sdf.format(listaAgendamento.get(0).getDataHoraComeco()));	
			session.setAttribute("horaComeco", sdf2.format(listaAgendamento.get(0).getDataHoraComeco()));
			session.setAttribute("dataFim", sdf.format(listaAgendamento.get(0).getDataHoraFim()));	
			session.setAttribute("horaFim", sdf2.format(listaAgendamento.get(0).getDataHoraFim()));
			
			view = request.getRequestDispatcher("AlterarAgendamento.jsp");
		}	
		

		view.forward(request, response);
		
	}

}
