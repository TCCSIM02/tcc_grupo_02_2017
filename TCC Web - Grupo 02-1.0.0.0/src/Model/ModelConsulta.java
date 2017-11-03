package Model;

import java.util.ArrayList;
import java.util.Date;

import DAO.DAOConsulta;
import TO.TOConsulta;


public class ModelConsulta {

	private int codConsulta, codAgendamento;
	private Date dataHoraConsultaInicio, dataHoraConsultaFinal;
	private String diagnostico, exames, receituario;
	
	public ModelConsulta() {
		// TODO Auto-generated constructor stub
	}

	public ModelConsulta(int codConsulta, int codAgendamento, Date dataHoraConsultaInicio, Date dataHoraConsultaFinal, String diagnostico,
			String exames, String receituario) {
		this.codConsulta = codConsulta;
		this.codAgendamento = codAgendamento;
		this.dataHoraConsultaInicio = dataHoraConsultaInicio;
		this.dataHoraConsultaFinal = dataHoraConsultaFinal;
		this.diagnostico = diagnostico;
		this.exames = exames;
		this.receituario = receituario;
	}

	/**
	 * @param codConsulta
	 */
	public ModelConsulta(int codConsulta) {
		this.codConsulta = codConsulta;
	}

	/**
	 * @return the codConsulta
	 */
	public int getCodConsulta() {
		return codConsulta;
	}
	
	public int getCodAgendamento() {
		return codAgendamento;
	}

	/**
	 * @return the dataHoraConsultaInicio
	 */
	public Date getDataHoraConsultaInicio() {
		return dataHoraConsultaInicio;
	}

	/**
	 * @return the dataHoraConsultaFinal
	 */
	public Date getDataHoraConsultaFinal() {
		return dataHoraConsultaFinal;
	}

	/**
	 * @return the diagnostico
	 */
	public String getDiagnostico() {
		return diagnostico;
	}
	
	public String getExames() {
		return exames;
	}
	
	public String getReceituario() {
		return receituario;
	}

	/**
	 * @return the statusConsulta
	 */

	/**
	 * @param codConsulta the codConsulta to set
	 */
	public void setCodConsulta(int codConsulta) {
		this.codConsulta = codConsulta;
	}

	public void setCodAgendamento(int codAgendamento) {
		this.codAgendamento = codAgendamento;
	}
	
	/**
	 * @param dataHoraConsultaInicio the dataHoraConsultaInicio to set
	 */
	public void setDataHoraConsultaInicio(Date dataHoraConsultaInicio) {
		this.dataHoraConsultaInicio = dataHoraConsultaInicio;
	}

	/**
	 * @param dataHoraConsultaFinal the dataHoraConsultaFinal to set
	 */
	public void setDataHoraConsultaFinal(Date dataHoraConsultaFinal) {
		this.dataHoraConsultaFinal = dataHoraConsultaFinal;
	}

	/**
	 * @param diagnostico the diagnostico to set
	 */
	public void setDiagnostico(String diagnostico) {
		this.diagnostico = diagnostico;
	}

	public void setExames(String exames) {
		this.exames = exames;
	}
	
	public void setReceituario(String receituario) {
		this.receituario = receituario;
	}
	
	public TOConsulta getTO(){
		
		TOConsulta toConsulta = new TOConsulta();
		
		toConsulta.setCodConsulta(codConsulta);
		toConsulta.setCodAgendamento(codAgendamento);
		toConsulta.setDataHoraConsultaInicio(dataHoraConsultaInicio);
		toConsulta.setDataHoraConsultaFinal(dataHoraConsultaFinal);
		toConsulta.setDiagnostico(diagnostico);
		toConsulta.setExames(exames);
		toConsulta.setReceituario(receituario);
		
		
		return toConsulta;
		
	}

	public void cadastrarConsulta(){
		DAOConsulta dao = new DAOConsulta();		
		TOConsulta toConsulta = getTO();
		dao.cadastrarConsulta(toConsulta); 
		this.codConsulta = toConsulta.getCodConsulta();
	}

	public void alterarConsulta(){
		DAOConsulta dao = new DAOConsulta();		
		TOConsulta toConsulta = getTO();
		dao.alterarConsulta(toConsulta);	
	}
	
	public void excluirConsulta(){
		DAOConsulta dao = new DAOConsulta();		
		TOConsulta toConsulta = new TOConsulta();
		toConsulta.setCodConsulta(codConsulta);
		dao.excluirConsulta(toConsulta);
	}
	

	public void consultarConsultaCod() throws ClassNotFoundException{
		DAOConsulta dao = new DAOConsulta();	
		TOConsulta toConsulta = dao.consultarConsultaCod(codConsulta);
		
		codConsulta = toConsulta.getCodConsulta();
		codAgendamento = toConsulta.getCodAgendamento();
		dataHoraConsultaFinal =  toConsulta.getDataHoraConsultaFinal();
		dataHoraConsultaInicio = toConsulta.getDataHoraConsultaInicio();
		diagnostico = toConsulta.getDiagnostico();
		exames = toConsulta.getExames();
		receituario = toConsulta.getReceituario();
	}
	
	public ArrayList<TOConsulta> listarConsultas() throws ClassNotFoundException{
		ArrayList<TOConsulta> lista;
		DAOConsulta dao = new DAOConsulta();
		lista = dao.listarConsultas();
		return lista;
	}
	
	public ArrayList<TOConsulta> listarConsultaCodAgendamento(String codAgendamento) throws ClassNotFoundException{
		ArrayList<TOConsulta> lista;
		DAOConsulta dao = new DAOConsulta();
		lista = dao.listarConsultaCodAgendamento(codAgendamento);
		return lista;
	}
	
}
