package Model;

import java.util.ArrayList;
import java.util.Date;

import DAO.DAOConsulta;
import DAO.DAOConsulta;
import TO.TOConsulta;
import TO.TOConsulta;

public class ModelConsulta {

	private int codConsulta;
	private Date dataHoraConsultaInicio, dataHoraConsultaFinal;
	private String diagnostico, statusConsulta;
	private double valorConsulta;
	
	public ModelConsulta() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param codConsulta
	 * @param dataHoraConsultaInicio
	 * @param dataHoraConsultaFinal
	 * @param diagnostico
	 * @param statusConsulta
	 * @param valorConsulta
	 */
	public ModelConsulta(int codConsulta, Date dataHoraConsultaInicio, Date dataHoraConsultaFinal, String diagnostico,
			String statusConsulta, double valorConsulta) {
		this.codConsulta = codConsulta;
		this.dataHoraConsultaInicio = dataHoraConsultaInicio;
		this.dataHoraConsultaFinal = dataHoraConsultaFinal;
		this.diagnostico = diagnostico;
		this.statusConsulta = statusConsulta;
		this.valorConsulta = valorConsulta;
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

	/**
	 * @return the statusConsulta
	 */
	public String getStatusConsulta() {
		return statusConsulta;
	}

	/**
	 * @return the valorConsulta
	 */
	public double getValorConsulta() {
		return valorConsulta;
	}

	/**
	 * @param codConsulta the codConsulta to set
	 */
	public void setCodConsulta(int codConsulta) {
		this.codConsulta = codConsulta;
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

	/**
	 * @param statusConsulta the statusConsulta to set
	 */
	public void setStatusConsulta(String statusConsulta) {
		this.statusConsulta = statusConsulta;
	}

	/**
	 * @param valorConsulta the valorConsulta to set
	 */
	public void setValorConsulta(double valorConsulta) {
		this.valorConsulta = valorConsulta;
	}
	
	public TOConsulta getTO(){
		
		TOConsulta toConsulta = new TOConsulta();
		
		toConsulta.setCodConsulta(codConsulta);
		toConsulta.setDataHoraConsultaFinal(dataHoraConsultaFinal);
		toConsulta.setDataHoraConsultaInicio(dataHoraConsultaFinal);
		toConsulta.setDiagnostico(diagnostico);
		toConsulta.setStatusConsulta(statusConsulta);
		toConsulta.setValorConsulta(valorConsulta);
		
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
	

	public void consultarConsultaCod(){
		DAOConsulta dao = new DAOConsulta();	
		TOConsulta toConsulta = dao.consultarConsultaCod(codConsulta);
		
		codConsulta = toConsulta.getCodConsulta();
		dataHoraConsultaFinal =  toConsulta.getDataHoraConsultaFinal();
		dataHoraConsultaInicio = toConsulta.getDataHoraConsultaInicio();
		diagnostico = toConsulta.getDiagnostico();
		statusConsulta = toConsulta.getStatusConsulta();
		valorConsulta = toConsulta.getValorConsulta();
	}
	
	public ArrayList<TOConsulta> listarConsultas() throws ClassNotFoundException{
		ArrayList<TOConsulta> lista;
		DAOConsulta dao = new DAOConsulta();
		lista = dao.listarConsultas();
		return lista;
	}
	
}
