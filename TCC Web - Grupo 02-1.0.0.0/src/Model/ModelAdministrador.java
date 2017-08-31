package Model;

import java.util.Date;

public class ModelAdministrador extends ModelUsuario{

	private int codAdministrador;
	
	public ModelAdministrador() {
		// TODO Auto-generated constructor stub
	}
	
	/**
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
	 * @param codAdministrador
	 */
	public ModelAdministrador(int numeroEndereco, Date dataCadastro,
			String nome, String cpf, String dataNascimento, String estadoCivil,
			String nacionalidade, String logradouro, String cep, String cidade,
			String uf, String pais, String tel1, String tel2, String cel,
			String flagAtivo, int codAdministrador) {
		super(numeroEndereco, dataCadastro, nome, cpf, dataNascimento,
				estadoCivil, nacionalidade, logradouro, cep, cidade, uf, pais,
				tel1, tel2, cel, flagAtivo);
		this.codAdministrador = codAdministrador;
	}



	/**
	 * @param codAdministrador
	 */
	public ModelAdministrador(int codAdministrador) {
		super();
		this.codAdministrador = codAdministrador;
	}
	
	/**
	 * @return the codAdministrador
	 */
	public int getCodAdministrador() {
		return codAdministrador;
	}

	/**
	 * @param codAdministrador the codAdministrador to set
	 */
	public void setCodAdministrador(int codAdministrador) {
		this.codAdministrador = codAdministrador;
	}
	
	public void cadastrarAdminstrador(){
		
	}

	public void alterarAdministrador(){
		
	}
	
	public void consultarAdministrador(){
		
	}
	
	public void excluirAdminstrador(){
		
	}
}
