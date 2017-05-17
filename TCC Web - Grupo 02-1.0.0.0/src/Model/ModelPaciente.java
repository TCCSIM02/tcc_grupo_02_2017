package Model;

import java.util.Date;

public class ModelPaciente extends ModelUsuario{

	private int codPaciente;
	private String numConvenio;
	
	public ModelPaciente() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param codPaciente
	 * @param numConvenio
	 */
	public ModelPaciente(int codPaciente, String numConvenio) {
		super();
		this.codPaciente = codPaciente;
		this.numConvenio = numConvenio;
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
	public ModelPaciente(int codUsuario, int numeroEndereco, Date dataCadastro, String nome, String cpf,
			String dataNascimento, String estadoCivil, String nacionalidade, String logradouro, String cep,
			String cidade, String uf, String pais, String tel1, String tel2, String cel, String flagAtivo) {
		super(codUsuario, numeroEndereco, dataCadastro, nome, cpf, dataNascimento, estadoCivil, nacionalidade, logradouro, cep,
				cidade, uf, pais, tel1, tel2, cel, flagAtivo);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param codPaciente
	 */
	public ModelPaciente(int codPaciente) {
		super();
		this.codPaciente = codPaciente;
	}

	/**
	 * @return the codPaciente
	 */
	public int getCodPaciente() {
		return codPaciente;
	}

	/**
	 * @return the numConvenio
	 */
	public String getNumConvenio() {
		return numConvenio;
	}

	/**
	 * @param codPaciente the codPaciente to set
	 */
	public void setCodPaciente(int codPaciente) {
		this.codPaciente = codPaciente;
	}

	/**
	 * @param numConvenio the numConvenio to set
	 */
	public void setNumConvenio(String numConvenio) {
		this.numConvenio = numConvenio;
	}

	public void cadastrarPaciente(){
		
	}

	public void alterarPaciente(){
		
	}
	
	public void consultarPaciente(){
		
	}
	
	public void excluirPaciente(){
		
	}
}
