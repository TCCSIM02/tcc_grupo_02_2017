package TO;

import java.util.Date;

public class TOConsulta {
	private int codConsulta, codAgendamento;
	private Date dataHoraConsultaInicio, dataHoraConsultaFinal;
	private String diagnostico, exames, receituario, cid;
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

	public String getCid() {
		return cid;
	}

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
	
	public void setCid(String cid) {
		this.cid = cid;
	}

}
