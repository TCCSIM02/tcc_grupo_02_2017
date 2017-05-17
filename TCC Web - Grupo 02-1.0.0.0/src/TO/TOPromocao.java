package TO;

import java.util.Date;

public class TOPromocao {
	private int codPromocao;
	private double valorPromocao;
	private Date dataInicio, dataTermino, dataCadastro;
	private String flagAtivo;
	/**
	 * @return the codPromocao
	 */
	public int getCodPromocao() {
		return codPromocao;
	}
	/**
	 * @return the valorPromocao
	 */
	public double getValorPromocao() {
		return valorPromocao;
	}
	/**
	 * @return the dataInicio
	 */
	public Date getDataInicio() {
		return dataInicio;
	}
	/**
	 * @return the dataTermino
	 */
	public Date getDataTermino() {
		return dataTermino;
	}
	/**
	 * @return the dataCadastro
	 */
	public Date getDataCadastro() {
		return dataCadastro;
	}
	/**
	 * @return the flagAtivo
	 */
	public String getFlagAtivo() {
		return flagAtivo;
	}
	/**
	 * @param codPromocao the codPromocao to set
	 */
	public void setCodPromocao(int codPromocao) {
		this.codPromocao = codPromocao;
	}
	/**
	 * @param valorPromocao the valorPromocao to set
	 */
	public void setValorPromocao(double valorPromocao) {
		this.valorPromocao = valorPromocao;
	}
	/**
	 * @param dataInicio the dataInicio to set
	 */
	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
	}
	/**
	 * @param dataTermino the dataTermino to set
	 */
	public void setDataTermino(Date dataTermino) {
		this.dataTermino = dataTermino;
	}
	/**
	 * @param dataCadastro the dataCadastro to set
	 */
	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}
	/**
	 * @param flagAtivo the flagAtivo to set
	 */
	public void setFlagAtivo(String flagAtivo) {
		this.flagAtivo = flagAtivo;
	}
}
