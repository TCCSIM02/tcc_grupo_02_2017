package Model;

import java.util.Date;

public class ModelAtendente extends ModelUsuario{

	private int codAtendente;
	
	public ModelAtendente() {
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
	 * @param codAtendente
	 */
	public ModelAtendente(int numeroEndereco, Date dataCadastro, String nome,
			String cpf, String dataNascimento, String estadoCivil,
			String nacionalidade, String logradouro, String cep, String cidade,
			String uf, String pais, String tel1, String tel2, String cel,
			String flagAtivo, int codAtendente) {
		super(numeroEndereco, dataCadastro, nome, cpf, dataNascimento,
				estadoCivil, nacionalidade, logradouro, cep, cidade, uf, pais,
				tel1, tel2, cel, flagAtivo);
		this.codAtendente = codAtendente;
	}



	/**
	 * @param codAtendente
	 */
	public ModelAtendente(int codAtendente) {
		super();
		this.codAtendente = codAtendente;
	}
	
	/**
	 * @return the codAtendente
	 */
	public int getCodAtendente() {
		return codAtendente;
	}

	/**
	 * @param codAtendente the codAtendente to set
	 */
	public void setCodAtendente(int codAtendente) {
		this.codAtendente = codAtendente;
	}

	public void cadastrarAtendente(){
		
	}

	public void alterarAtendente(){
		
	}
	
	public void consultarAtendente(){
		
	}
	
	public void excluirAtendente(){
		
	}
	
}
