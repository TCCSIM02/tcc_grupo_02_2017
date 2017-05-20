package TO;

import java.util.Date;

public class TOPlano {
	private int codPlano;
	private String nomePlano, registroAns, tipoPlano, flagAtivo;
	private Date dataCadastro;
	/**
	 * @return the codPlano
	 */
	public int getCodPlano() {
		return codPlano;
	}
	/**
	 * @return the nomePlano
	 */
	public String getNomePlano() {
		return nomePlano;
	}
	/**
	 * @return the registroAns
	 */
	public String getRegistroAns() {
		return registroAns;
	}
	/**
	 * @return the tipoPlano
	 */
	public String getTipoPlano() {
		return tipoPlano;
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
	 * @param codPlano the codPlano to set
	 */
	public void setCodPlano(int codPlano) {
		this.codPlano = codPlano;
	}
	/**
	 * @param nomePlano the nomePlano to set
	 */
	public void setNomePlano(String nomePlano) {
		this.nomePlano = nomePlano;
	}
	/**
	 * @param registroAns the registroAns to set
	 */
	public void setRegistroAns(String registroAns) {
		this.registroAns = registroAns;
	}
	/**
	 * @param tipoPlano the tipoPlano to set
	 */
	public void setTipoPlano(String tipoPlano) {
		this.tipoPlano = tipoPlano;
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
		
}
