package TO;

public class TOMedico extends TOUsuario {
	private int codMedico, codUnidade;
	private String crm, cro;
	/**
	 * @return the codMedico
	 */
	public int getCodMedico() {
		return codMedico;
	}
	
	public int getCodUnidade() {
		return codUnidade;
	}
	/**
	 * @return the crm
	 */
	public String getCrm() {
		return crm;
	}
	/**
	 * @return the cro
	 */
	public String getCro() {
		return cro;
	}
	/**
	 * @param codMedico the codMedico to set
	 */
	public void setCodMedico(int codMedico) {
		this.codMedico = codMedico;
	}
	
	public void setCodUnidade(int codUnidade) {
		this.codUnidade = codUnidade;
	}
	/**
	 * @param crm the crm to set
	 */
	public void setCrm(String crm) {
		this.crm = crm;
	}
	/**
	 * @param cro the cro to set
	 */
	public void setCro(String cro) {
		this.cro = cro;
	}
	
}
