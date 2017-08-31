package Model;

import java.util.Date;

import DAO.DAOPaciente;
import DAO.DAOPlano;
import TO.TOPaciente;
import TO.TOPlano;

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
	 * @param codPaciente
	 * @param numConvenio
	 */
	public ModelPaciente(int numeroEndereco, Date dataCadastro, String nome,
			String cpf, String dataNascimento, String estadoCivil,
			String nacionalidade, String logradouro, String cep, String cidade,
			String uf, String pais, String tel1, String tel2, String cel,
			String flagAtivo, int codPaciente, String numConvenio) {
		super(numeroEndereco, dataCadastro, nome, cpf, dataNascimento,
				estadoCivil, nacionalidade, logradouro, cep, cidade, uf, pais,
				tel1, tel2, cel, flagAtivo);
		this.codPaciente = codPaciente;
		this.numConvenio = numConvenio;
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
	
	public TOPaciente getTO(){
	
		TOPaciente toPaciente = new TOPaciente();
		
		/*TOUsuario*/
		toPaciente.setNumeroEndereco(super.getNumeroEndereco()) ;
		toPaciente.setDataCadastro(super.getDataCadastro())  ;
		toPaciente.setNome(super.getNome());
		toPaciente.setCpf(super.getCpf());
		toPaciente.setDataNascimento(super.getDataNascimento()) ;
		toPaciente.setEstadoCivil(super.getEstadoCivil()) ;
		toPaciente.setNacionalidade(super.getNacionalidade());
		toPaciente.setLogradouro(super.getLogradouro());
		toPaciente.setCep(super.getCep()) ;
		toPaciente.setCidade(super.getCidade()) ;
		toPaciente.setUf(super.getUf()) ;
		toPaciente.setPais(super.getPais()) ;
		toPaciente.setTel1(super.getTel1()); 
		toPaciente.setTel2(super.getTel2()); 
		toPaciente.setCel(super.getCel()) ;
		toPaciente.setFlagAtivo(super.getFlagAtivo());
		
		/*TOPaciente*/
		toPaciente.setCodPaciente(getCodPaciente());
		toPaciente.setNumConvenio(getNumConvenio());
		
		return null;
	}

	public void cadastrarPaciente(){
		
		DAOPaciente dao = new DAOPaciente();		
		TOPaciente toPaciente = getTO();
		dao.cadastrarPaciente(toPaciente); 
		this.codPaciente = toPaciente.getCodPaciente();
		
	}

	public void alterarPaciente(){
		
	}
	
	public void consultarPaciente(){
		
	}
	
	public void excluirPaciente(){
		
	}
}
