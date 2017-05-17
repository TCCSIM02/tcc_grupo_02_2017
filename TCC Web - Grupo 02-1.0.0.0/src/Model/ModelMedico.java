package Model;

import java.util.Date;

public class ModelMedico extends ModelUsuario{

	private int codMedico;
	private String crm, cro;
	
	public ModelMedico() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param codUsuario
	 * @param numeroEndereco
	 * @param dataCadastro
	 * @param nome
	 * @param cpf
	 * @param dataNascimento
	 * @param estadoCivil
	 * @param nacionalidade
	 * @param logradouro
	 * @param cep
	 * @param cidade
	 * @param uf
	 * @param pais
	 * @param tel1
	 * @param tel2
	 * @param cel
	 * @param flagAtivo
	 */
	public ModelMedico(int codUsuario, int numeroEndereco, Date dataCadastro, String nome, String cpf,
			String dataNascimento, String estadoCivil, String nacionalidade, String logradouro, String cep,
			String cidade, String uf, String pais, String tel1, String tel2, String cel, String flagAtivo) {
		super(codUsuario, numeroEndereco, dataCadastro, nome, cpf, dataNascimento, estadoCivil, nacionalidade, logradouro, cep,
				cidade, uf, pais, tel1, tel2, cel, flagAtivo);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param codMedico
	 * @param crm
	 * @param cro
	 */
	public ModelMedico(int codMedico, String crm, String cro) {
		super();
		this.codMedico = codMedico;
		this.crm = crm;
		this.cro = cro;
	}

	/**
	 * @param codMedico
	 */
	public ModelMedico(int codMedico) {
		super();
		this.codMedico = codMedico;
	}

	/**
	 * @return the codMedico
	 */
	public int getCodMedico() {
		return codMedico;
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

	public void cadastrarMedico(){
		
	}

	public void alterarMedico(){
		
	}
	
	public void consultarMedico(){
		
	}
	
	public void excluirMedico(){
		
	}
}
