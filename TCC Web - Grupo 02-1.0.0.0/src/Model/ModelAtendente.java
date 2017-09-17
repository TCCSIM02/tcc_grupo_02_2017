package Model;

import java.util.ArrayList;
import java.util.Date;

import DAO.DAOAtendente;
import TO.TOAtendente;

public class ModelAtendente extends ModelUsuario{

	private int codAtendente;
	public int codLoginCadastrado;
	
	public ModelAtendente() {
		// TODO Auto-generated constructor stub
	}

	public ModelAtendente(int codAtendente) {
		super();
		this.codAtendente = codAtendente;
	}
	
	public ModelAtendente(String numeroEndereco, Date dataCadastro, String nome,
			String cpf, Date dataNascimento, String estadoCivil, String email,
			String nacionalidade, String endereco, String cep, String cidade,
			String uf, String pais, String tel1, String tel2, String cel,
			String flagAtivo, int codAtendente) {
		super(numeroEndereco, dataCadastro, nome, cpf, dataNascimento,
				estadoCivil, email, nacionalidade, endereco, cep, cidade, uf, pais,
				tel1, tel2, cel, flagAtivo);
		this.codAtendente = codAtendente;
	}

	public int getCodAtendente() {
		return codAtendente;
	}


	public void setCodAtendente(int codAtendente) {
		this.codAtendente = codAtendente;
	}

	public TOAtendente getTO(){
		
		TOAtendente toAtendente = new TOAtendente();
		
		/*TOUsuario*/
		toAtendente.setNumeroEndereco(super.getNumeroEndereco()) ;
		toAtendente.setDataCadastro(super.getDataCadastro())  ;
		toAtendente.setNome(super.getNome());
		toAtendente.setCpf(super.getCpf());
		toAtendente.setDataNascimento(super.getDataNascimento()) ;
		toAtendente.setEstadoCivil(super.getEstadoCivil()) ;
		toAtendente.setEmail(super.getEmail()) ;
		toAtendente.setNacionalidade(super.getNacionalidade());
		toAtendente.setEndereco(super.getEndereco());
		toAtendente.setCep(super.getCep()) ;
		toAtendente.setCidade(super.getCidade()) ;
		toAtendente.setUf(super.getUf()) ;
		toAtendente.setPais(super.getPais()) ;
		toAtendente.setTel1(super.getTel1()); 
		toAtendente.setTel2(super.getTel2()); 
		toAtendente.setCel(super.getCel()) ;
		toAtendente.setFlagAtivo(super.getFlagAtivo());
		
		/*TOAtendente*/
		toAtendente.setCodAtendente(getCodAtendente());

		return toAtendente;
	}
	
	
	public void cadastrarAtendente(){
		
		DAOAtendente dao = new DAOAtendente();		
		TOAtendente toAtendente = getTO();
		dao.cadastrarAtendente(toAtendente,codLoginCadastrado); 
		this.codAtendente = toAtendente.getCodAtendente();
		
	}

	public void alterarAtendente(){
		DAOAtendente dao = new DAOAtendente();		
		TOAtendente toAtendente = getTO();
		dao.alterarAtendente(toAtendente);
	}

	public void excluirAtendente(){
		DAOAtendente dao = new DAOAtendente();
		TOAtendente toAtendente = new TOAtendente();
		toAtendente.setCodAtendente(codAtendente);
		dao.excluirAtendente(toAtendente);
	}
	
	public void consultarAtendenteCod() throws ClassNotFoundException  {

		DAOAtendente dao = new DAOAtendente();

		TOAtendente toAtendente = dao.consultarAtendenteCod(codAtendente);

		codAtendente = toAtendente.getCodAtendente();
		super.setNumeroEndereco(toAtendente.getNumeroEndereco()); 
		super.setDataCadastro(toAtendente.getDataCadastro());
		super.setNome(toAtendente.getNome());
		super.setCpf(toAtendente.getCpf());
		super.setDataNascimento(toAtendente.getDataNascimento());
		super.setEstadoCivil(toAtendente.getEstadoCivil());
		super.setEmail(toAtendente.getEmail());
		super.setNacionalidade(toAtendente.getNacionalidade());
		super.setEndereco(toAtendente.getEndereco());
		super.setCep(toAtendente.getCep());
		super.setCidade(toAtendente.getCidade());
		super.setUf(toAtendente.getUf());
		super.setPais(toAtendente.getPais());
		super.setTel1(toAtendente.getTel1());
		super.setTel2(toAtendente.getTel2());
		super.setCel(toAtendente.getCel());
		super.setFlagAtivo(toAtendente.getFlagAtivo());
	
	}
	
	
	public ArrayList<TOAtendente> listarAtendentes() throws ClassNotFoundException{
		ArrayList<TOAtendente> lista;
		DAOAtendente dao = new DAOAtendente();
		lista = dao.listarAtendentes();
		return lista;
	}
	
	public ArrayList<TOAtendente> listarAtendentes(String chave) throws ClassNotFoundException{
		ArrayList<TOAtendente> lista;
		DAOAtendente dao = new DAOAtendente();
		lista = dao.listarAtendente(chave);
		return lista;
	}	
	
	
}
