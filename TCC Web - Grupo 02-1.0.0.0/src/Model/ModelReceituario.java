package Model;

import java.util.Date;
import TO.TOReceituario;

public class ModelReceituario {

	private int codReceituario;
	private double quantidadeDoses;
	private String descricaoReceita, recomendacoes, periodo, duracao, flagAtivo;
	private Date dataLimite;
	
	public ModelReceituario() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param codReceituario
	 */
	public ModelReceituario(int codReceituario) {
		this.codReceituario = codReceituario;
	}

	/**
	 * @param codReceituario
	 * @param quantidadeDoses
	 * @param descricaoReceita
	 * @param recomendacoes
	 * @param periodo
	 * @param duracao
	 * @param flagAtivo
	 * @param dataLimite
	 */
	public ModelReceituario(int codReceituario, double quantidadeDoses, String descricaoReceita, String recomendacoes,
			String periodo, String duracao, String flagAtivo, Date dataLimite) {
		this.codReceituario = codReceituario;
		this.quantidadeDoses = quantidadeDoses;
		this.descricaoReceita = descricaoReceita;
		this.recomendacoes = recomendacoes;
		this.periodo = periodo;
		this.duracao = duracao;
		this.flagAtivo = flagAtivo;
		this.dataLimite = dataLimite;
	}

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
	
	public TOReceituario getTO(){
		
		TOReceituario toReceituario = new TOReceituario();
		
		toReceituario.setCodReceituario(codReceituario);
		toReceituario.setDataValidade(dataLimite);
		toReceituario.setDescricaoReceita(descricaoReceita);
		toReceituario.setDuracao(duracao);
		toReceituario.setFlagAtivo(flagAtivo);
		toReceituario.setPeriodo(periodo);
		toReceituario.setQuantidadeDoses(quantidadeDoses);
		toReceituario.setRecomendacoes(recomendacoes);
		
		return toReceituario;
	}

	public void cadastrarReceituario(){
		
	}
	
	public void consultarReceituario(){
		
	}
	
	public void consultarMedicamento(){
		
	}

}
