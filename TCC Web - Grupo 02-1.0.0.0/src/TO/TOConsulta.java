package TO;

import java.util.Date;

public class TOConsulta {
	private int codConsulta;
	private Date dataHoraConsultaInicio, dataHoraConsultaFinal;
	private String diagnostico, statusConsulta;
	private double valorConsulta;
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
}
