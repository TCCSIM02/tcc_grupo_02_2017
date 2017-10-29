package Command;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Model.ModelAgendamento;
import Model.ModelMedico;
import TO.TOMedico;

public class ListarConsultasMedico implements Command {

	@Override
	public void executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		RequestDispatcher view = null;
		HttpSession session = request.getSession();
		
		String codLogin = session.getAttribute("codLogin").toString();	
		
		ModelAgendamento modelAgendamento = new ModelAgendamento();

		view = request.getRequestDispatcher("ListarConsultasMedico.jsp");
		
		ModelMedico modelMedico = new ModelMedico(); 
		
		ArrayList<TOMedico> listaMedico = new ArrayList<>(); 
		try {
			listaMedico = modelMedico.listarMedicoLogado(codLogin);
			//lista = modelMedico.listarMedicos(especialidadeValor);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		
		
		try {
			session.setAttribute("jsonCalendario", modelAgendamento.listarAgendamentosMedico(listaMedico.get(0).getCodMedico() ) );
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		view.forward(request, response);
	}
	
	
}
