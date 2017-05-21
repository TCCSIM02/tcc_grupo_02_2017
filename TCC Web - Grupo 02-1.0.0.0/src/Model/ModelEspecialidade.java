package Model;

import TO.TOEspecialidade;

public class ModelEspecialidade {

	private int codEspecialidade;
	private String flagAtivo, descricao;
	
	public ModelEspecialidade() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param codEspecialidade
	 */
	public ModelEspecialidade(int codEspecialidade) {
		this.codEspecialidade = codEspecialidade;
	}
	
	/**
	 * @param codEspecialidade
	 * @param flagAtivo
	 * @param descricao
	 */
	public ModelEspecialidade(int codEspecialidade, String flagAtivo, String descricao) {
		this.codEspecialidade = codEspecialidade;
		this.flagAtivo = flagAtivo;
		this.descricao = descricao;
	}

	/**
	 * @return the codEspecialidade
	 */
	public int getCodEspecialidade() {
		return codEspecialidade;
	}

	/**
	 * @return the flagAtivo
	 */
	public String getFlagAtivo() {
		return flagAtivo;
	}

	/**
	 * @return the descricao
	 */
	public String getDescricao() {
		return descricao;
	}

	/**
	 * @param codEspecialidade the codEspecialidade to set
	 */
	public void setCodEspecialidade(int codEspecialidade) {
		this.codEspecialidade = codEspecialidade;
	}

	/**
	 * @param flagAtivo the flagAtivo to set
	 */
	public void setFlagAtivo(String flagAtivo) {
		this.flagAtivo = flagAtivo;
	}

	/**
	 * @param descricao the descricao to set
	 */
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public TOEspecialidade getTO(){
		
		TOEspecialidade toEspecialidade = new TOEspecialidade();
		
		toEspecialidade.setCodEspecialidade(codEspecialidade);
		toEspecialidade.setDescricao(descricao);
		toEspecialidade.setFlagAtivo(descricao);
		
		return toEspecialidade;
	}
	
	public void cadastrarEspecialidade(){
		
	}

	public void alterarEspecialidade(){
		
	}
	
	public void consultarEspecialidade(){
		
	}
	
	public void excluirEspecialidade(){
		
	}
}
