package Model;

import java.util.ArrayList;
import java.util.Date;

import DAO.DAOAdministrador;
import TO.TOAdministrador;


public class ModelAdministrador extends ModelUsuario{

	private int codAdministrador;
	public int codLoginCadastrado;
	
	public ModelAdministrador() {
		// TODO Auto-generated constructor stub
	}
	

	public ModelAdministrador(int codAdministrador) {
		super();
		this.codAdministrador = codAdministrador;
	}
	

	public ModelAdministrador(String numeroEndereco, Date dataCadastro, String nome,
			String cpf, Date dataNascimento, String estadoCivil, String email,
			String nacionalidade, String endereco, String cep, String cidade,
			String uf, String pais, String tel1, String tel2, String cel,
			String flagAtivo, int codAdministrador) {
		super(numeroEndereco, dataCadastro, nome, cpf, dataNascimento,
				estadoCivil, email, nacionalidade, endereco, cep, cidade, uf, pais,
				tel1, tel2, cel, flagAtivo);
		this.codAdministrador = codAdministrador;
	}


	public int getCodAdministrador() {
		return codAdministrador;
	}

	public void setCodAdministrador(int codAdministrador) {
		this.codAdministrador = codAdministrador;
	}
	
	public TOAdministrador getTO(){
		
		TOAdministrador toAdministrador = new TOAdministrador();
		
		/*TOUsuario*/
		toAdministrador.setNumeroEndereco(super.getNumeroEndereco()) ;
		toAdministrador.setDataCadastro(super.getDataCadastro())  ;
		toAdministrador.setNome(super.getNome());
		toAdministrador.setCpf(super.getCpf());
		toAdministrador.setDataNascimento(super.getDataNascimento()) ;
		toAdministrador.setEstadoCivil(super.getEstadoCivil()) ;
		toAdministrador.setEmail(super.getEmail()) ;
		toAdministrador.setNacionalidade(super.getNacionalidade());
		toAdministrador.setEndereco(super.getEndereco());
		toAdministrador.setCep(super.getCep()) ;
		toAdministrador.setCidade(super.getCidade()) ;
		toAdministrador.setUf(super.getUf()) ;
		toAdministrador.setPais(super.getPais()) ;
		toAdministrador.setTel1(super.getTel1()); 
		toAdministrador.setTel2(super.getTel2()); 
		toAdministrador.setCel(super.getCel()) ;
		toAdministrador.setFlagAtivo(super.getFlagAtivo());
		
		/*TOAdministrador*/
		toAdministrador.setCodAdministrador(getCodAdministrador());

		return toAdministrador;
	}

	public void cadastrarAdministrador(){
		
		DAOAdministrador dao = new DAOAdministrador();		
		TOAdministrador toAdministrador = getTO();
		dao.cadastrarAdministrador(toAdministrador,codLoginCadastrado); 
		this.codAdministrador = toAdministrador.getCodAdministrador();
		
	}

	public void alterarAdministrador(){
		DAOAdministrador dao = new DAOAdministrador();		
		TOAdministrador toAdministrador = getTO();
		dao.alterarAdministrador(toAdministrador);
	}

	public void excluirAdministrador(){
		DAOAdministrador dao = new DAOAdministrador();
		TOAdministrador toAdministrador = new TOAdministrador();
		toAdministrador.setCodAdministrador(codAdministrador);
		dao.excluirAdministrador(toAdministrador);
	}
	
	public void consultarAdministradorCod() throws ClassNotFoundException  {

		DAOAdministrador dao = new DAOAdministrador();

		TOAdministrador toAdministrador = dao.consultarAdministradorCod(codAdministrador);

		codAdministrador = toAdministrador.getCodAdministrador();
		super.setNumeroEndereco(toAdministrador.getNumeroEndereco()); 
		super.setDataCadastro(toAdministrador.getDataCadastro());
		super.setNome(toAdministrador.getNome());
		super.setCpf(toAdministrador.getCpf());
		super.setDataNascimento(toAdministrador.getDataNascimento());
		super.setEstadoCivil(toAdministrador.getEstadoCivil());
		super.setEmail(toAdministrador.getEmail());
		super.setNacionalidade(toAdministrador.getNacionalidade());
		super.setEndereco(toAdministrador.getEndereco());
		super.setCep(toAdministrador.getCep());
		super.setCidade(toAdministrador.getCidade());
		super.setUf(toAdministrador.getUf());
		super.setPais(toAdministrador.getPais());
		super.setTel1(toAdministrador.getTel1());
		super.setTel2(toAdministrador.getTel2());
		super.setCel(toAdministrador.getCel());
		super.setFlagAtivo(toAdministrador.getFlagAtivo());
	
	}
	
	
	public ArrayList<TOAdministrador> listarAdministradores() throws ClassNotFoundException{
		ArrayList<TOAdministrador> lista;
		DAOAdministrador dao = new DAOAdministrador();
		lista = dao.listarAdministradores();
		return lista;
	}
	
	public ArrayList<TOAdministrador> listarAdministradores(String chave) throws ClassNotFoundException{
		ArrayList<TOAdministrador> lista;
		DAOAdministrador dao = new DAOAdministrador();
		lista = dao.listarAdministrador(chave);
		return lista;
	}	
}
