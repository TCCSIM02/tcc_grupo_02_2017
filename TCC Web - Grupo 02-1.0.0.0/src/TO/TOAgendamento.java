package TO;

import java.util.Date;

public class TOAgendamento {
	private int codAgendamento;
	private String statusAgendamento, flagAtivo;
	private Date dataCadastro, dataHoraComeco, dataHoraFim;
	/**
	 * @return the codAgendamento
	 */
	public int getCodAgendamento() {
		return codAgendamento;
	}
	/**
	 * @return the statusAgendamento
	 */
	public String getStatusAgendamento() {
		return statusAgendamento;
	}
	/**
	 * @return the flagAtivo
	 */
	public String getFlagAtivo() {
		return flagAtivo;
	}
	/**
	 * @return the dataCadastro
	 */
	public Date getDataCadastro() {
		return dataCadastro;
	}
	/**
	 * @return the dataHoraComeco
	 */
	public Date getDataHoraComeco() {
		return dataHoraComeco;
	}
	/**
	 * @return the dataHoraFim
	 */
	public Date getDataHoraFim() {
		return dataHoraFim;
	}
	/**
	 * @param codAgendamento the codAgendamento to set
	 */
	public void setCodAgendamento(int codAgendamento) {
		this.codAgendamento = codAgendamento;
	}
	/**
	 * @param statusAgendamento the statusAgendamento to set
	 */
	public void setStatusAgendamento(String statusAgendamento) {
		this.statusAgendamento = statusAgendamento;
	}
	/**
	 * @param flagAtivo the flagAtivo to set
	 */
	public void setFlagAtivo(String flagAtivo) {
		this.flagAtivo = flagAtivo;
	}
	/**
	 * @param dataCadastro the dataCadastro to set
	 */
	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}
	/**
	 * @param dataHoraComeco the dataHoraComeco to set
	 */
	public void setDataHoraComeco(Date dataHoraComeco) {
		this.dataHoraComeco = dataHoraComeco;
	}
	/**
	 * @param dataHoraFim the dataHoraFim to set
	 */
	public void setDataHoraFim(Date dataHoraFim) {
		this.dataHoraFim = dataHoraFim;
	}
	
}
