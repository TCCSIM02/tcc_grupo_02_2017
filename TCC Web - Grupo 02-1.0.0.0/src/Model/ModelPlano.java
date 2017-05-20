/*	
 * 16/05/2017 - Nilton Filho - Criação da classe 
 */
package Model;

import java.util.Date;
import TO.TOPlano;

public class ModelPlano {

	private int codPlano;
	private String nomePlano, registroAns, tipoPlano, flagAtivo;
	private Date dataCadastro;
	
	public ModelPlano() {
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * @param codPlano
	 * @param nomePlano
	 * @param registroAns
	 * @param tipoPlano
	 * @param flagAtivo
	 * @param dataCadastro
	 */
	public ModelPlano(int codPlano, String nomePlano, String registroAns, String tipoPlano, String flagAtivo,
			Date dataCadastro) {
		super();
		this.codPlano = codPlano;
		this.nomePlano = nomePlano;
		this.registroAns = registroAns;
		this.tipoPlano = tipoPlano;
		this.flagAtivo = flagAtivo;
		this.dataCadastro = dataCadastro;
	}

	/**
	 * @param codPlano
	 */
	public ModelPlano(int codPlano) {
		super();
		this.codPlano = codPlano;
	}

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

	public TOPlano getTO(){
		
		TOPlano toPlano = new TOPlano();
		
		toPlano.setCodPlano(codPlano);
		toPlano.setDataCadastro(dataCadastro);
		toPlano.setFlagAtivo(flagAtivo);
		toPlano.setNomePlano(nomePlano);
		toPlano.setRegistroAns(registroAns);
		toPlano.setTipoPlano(flagAtivo);

		
		return toPlano;
	}
	
	public void cadastrarPlano(){
		
	}
	
	public void consultarPlano(){
		
	}

	public void alterarPlano(){
		
	}
	
	public void excluirPlano(){
		
	}


	
	
	
	
}
