package TO;

import java.io.File;

public class TOExame {

	private int codExame;
	private double valorExame;
	private String descricao;
	private File resultadoExame;
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
		
}
