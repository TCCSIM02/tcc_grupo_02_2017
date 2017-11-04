package Command;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Model.ModelEspecialidade;
import Model.ModelMedico;
import Model.ModelPaciente;
import Model.ModelUnidade;
import TO.TOEspecialidade;
import TO.TOMedico;
import TO.TOPaciente;
import TO.TOUnidade;

public class PreencheAgendamento  implements Command {
	
	@Override
	public void executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		RequestDispatcher view = null;
		HttpSession session = request.getSession();
		
		String pEventDate = request.getParameter("eventDate");
		String pPacienteValor =	request.getParameter("pacienteValor");
		String pEspecialidadeValor =	request.getParameter("especialidadeValor");
		String pUnidadeValor =	request.getParameter("unidadeValor");
		String pMedicoValor =	request.getParameter("medicoValor");
				
		
		ModelMedico modelMedico = new ModelMedico();
		ModelPaciente modelPaciente = new ModelPaciente();
		ModelEspecialidade modelEspecialidade = new ModelEspecialidade();
		ModelUnidade modelUnidade= new ModelUnidade();
		
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
		
		
			
		view = request.getRequestDispatcher("CriarAgendamento.jsp");

		view.forward(request, response);
		
	}

}
