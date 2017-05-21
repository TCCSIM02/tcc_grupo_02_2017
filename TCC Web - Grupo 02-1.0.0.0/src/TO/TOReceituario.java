package TO;

import java.util.Date;

public class TOReceituario {
	private int codReceituario;
	private double quantidadeDoses;
	private String descricaoReceita, recomendacoes, periodo, duracao, flagAtivo;
	private Date dataLimite;
	/**
	 * @return the codReceituario
	 */
	public int getCodReceituario() {
		return codReceituario;
	}
	/**
	 * @return the quantidadeDoses
	 */
	public double getQuantidadeDoses() {
		return quantidadeDoses;
	}
	/**
	 * @return the descricaoReceita
	 */
	public String getDescricaoReceita() {
		return descricaoReceita;
	}
	/**
	 * @return the recomendacoes
	 */
	public String getRecomendacoes() {
		return recomendacoes;
	}
	/**
	 * @return the periodo
	 */
	public String getPeriodo() {
		return periodo;
	}
	/**
	 * @return the duracao
	 */
	public String getDuracao() {
		return duracao;
	}
	/**
	 * @return the flagAtivo
	 */
	public String getFlagAtivo() {
		return flagAtivo;
	}
	/**
	 * @return the dataLimite
	 */
	public Date getDataValidade() {
		return dataLimite;
	}
	/**
	 * @param codReceituario the codReceituario to set
	 */
	public void setCodReceituario(int codReceituario) {
		this.codReceituario = codReceituario;
	}
	/**
	 * @param quantidadeDoses the quantidadeDoses to set
	 */
	public void setQuantidadeDoses(double quantidadeDoses) {
		this.quantidadeDoses = quantidadeDoses;
	}
	/**
	 * @param descricaoReceita the descricaoReceita to set
	 */
	public void setDescricaoReceita(String descricaoReceita) {
		this.descricaoReceita = descricaoReceita;
	}
	/**
	 * @param recomendacoes the recomendacoes to set
	 */
	public void setRecomendacoes(String recomendacoes) {
		this.recomendacoes = recomendacoes;
	}
	/**
	 * @param periodo the periodo to set
	 */
	public void setPeriodo(String periodo) {
		this.periodo = periodo;
	}
	/**
	 * @param duracao the duracao to set
	 */
	public void setDuracao(String duracao) {
		this.duracao = duracao;
	}
	/**
	 * @param flagAtivo the flagAtivo to set
	 */
	public void setFlagAtivo(String flagAtivo) {
		this.flagAtivo = flagAtivo;
	}
	/**
	 * @param dataLimite the dataLimite to set
	 */
	public void setDataValidade(Date dataLimite) {
		this.dataLimite = dataLimite;
	}
}
