package Model;

import java.util.Date;

public class ModelAtendente extends ModelUsuario{

	private int codAtendente;
	
	public ModelAtendente() {
		// TODO Auto-generated constructor stub
	}

	public ModelAtendente(String numeroEndereco, Date dataCadastro, String nome,
			String cpf, String dataNascimento, String estadoCivil, String email,
			String nacionalidade, String endereco, String logradouro, String cep, String cidade,
			String uf, String pais, String tel1, String tel2, String cel,
			String flagAtivo, int codAtendente) {
		super(numeroEndereco, dataCadastro, nome, cpf, dataNascimento,
				estadoCivil, email, nacionalidade, endereco, cep, cidade, uf, pais,
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
