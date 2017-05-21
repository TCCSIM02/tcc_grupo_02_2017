package Model;

import java.io.File;

public class ModelExame {

	private int codExame;
	private double valorExame;
	private String descricao;
	private File resultadoExame;
	
	/**
	 * @param codExame
	 * @param valorExame
	 * @param descricao
	 * @param resultadoExame
	 */
	public ModelExame(int codExame, double valorExame, String descricao, File resultadoExame) {
		this.codExame = codExame;
		this.valorExame = valorExame;
		this.descricao = descricao;
		this.resultadoExame = resultadoExame;
	}

	/**
	 * @param codExame
	 */
	public ModelExame(int codExame) {
		this.codExame = codExame;
	}

	public ModelExame() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return the codExame
	 */
	public int getCodExame() {
		return codExame;
	}

	/**
	 * @return the valorExame
	 */
	public double getValorExame() {
		return valorExame;
	}

	/**
	 * @return the descricao
	 */
	public String getDescricao() {
		return descricao;
	}

	/**
	 * @return the resultadoExame
	 */
	public File getResultadoExame() {
		return resultadoExame;
	}

	/**
	 * @param codExame the codExame to set
	 */
	public void setCodExame(int codExame) {
		this.codExame = codExame;
	}

	/**
	 * @param valorExame the valorExame to set
	 */
	public void setValorExame(double valorExame) {
		this.valorExame = valorExame;
	}

	/**
	 * @param descricao the descricao to set
	 */
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	/**
	 * @param resultadoExame the resultadoExame to set
	 */
	public void setResultadoExame(File resultadoExame) {
		this.resultadoExame = resultadoExame;
	}
	
	public void cadastrarExame(){
		
	}
	
	public void excluirExame(){
	
	}

}
