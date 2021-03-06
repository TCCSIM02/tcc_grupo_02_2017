package Model;

import java.util.ArrayList;
import java.util.Date;

import DAO.DAOMedico;
import TO.TOMedico;

public class ModelMedico extends ModelUsuario{

	private int codMedico, codUnidade;
	public int codLoginCadastrado;
	private String crm, cro;
	
	public ModelMedico() {
		// TODO Auto-generated constructor stub
	}

	public ModelMedico(String numeroEndereco, Date dataCadastro, String nome,
			String cpf, Date dataNascimento, String estadoCivil, String email,
			String nacionalidade, String endereco, String cep, String cidade,
			String uf, String pais, String tel1, String tel2, String cel,
			String flagAtivo, int codMedico, int codUnidade, String crm, String cro) {
		super(numeroEndereco, dataCadastro, nome, cpf, dataNascimento,
				estadoCivil, email, nacionalidade, endereco, cep, cidade, uf, pais,
				tel1, tel2, cel, flagAtivo);
		this.codMedico = codMedico;
		this.codUnidade = codUnidade;
		this.crm = crm;
		this.cro = cro;
	}

	public ModelMedico(int codMedico,int codUnidade, String crm, String cro) {
		super();
		this.codMedico = codMedico;
		this.codUnidade = codUnidade;
		this.crm = crm;
		this.cro = cro;
	}

	public ModelMedico(int codMedico) {
		super();
		this.codMedico = codMedico;
	}

	public int getCodMedico() {
		return codMedico;
	}
	
	public int getCodUnidade() {
		return codUnidade;
	}


	public String getCrm() {
		return crm;
	}


	public String getCro() {
		return cro;
	}


	public void setCodMedico(int codMedico) {
		this.codMedico = codMedico;
	}

	public void setCodUnidade(int codUnidade) {
		this.codUnidade = codUnidade;
	}


	public void setCrm(String crm) {
		this.crm = crm;
	}


	public void setCro(String cro) {
		this.cro = cro;
	}
	
	
	public TOMedico getTO(){
		
		TOMedico toMedico = new TOMedico();
		
		/*TOUsuario*/
		toMedico.setNumeroEndereco(super.getNumeroEndereco()) ;
		toMedico.setDataCadastro(super.getDataCadastro())  ;
		toMedico.setNome(super.getNome());
		toMedico.setCpf(super.getCpf());
		toMedico.setDataNascimento(super.getDataNascimento()) ;
		toMedico.setEstadoCivil(super.getEstadoCivil()) ;
		toMedico.setEmail(super.getEmail()) ;
		toMedico.setNacionalidade(super.getNacionalidade());
		toMedico.setEndereco(super.getEndereco());
		toMedico.setCep(super.getCep()) ;
		toMedico.setCidade(super.getCidade()) ;
		toMedico.setUf(super.getUf()) ;
		toMedico.setPais(super.getPais()) ;
		toMedico.setTel1(super.getTel1()); 
		toMedico.setTel2(super.getTel2()); 
		toMedico.setCel(super.getCel()) ;
		toMedico.setFlagAtivo(super.getFlagAtivo());
		
		/*TOMedico*/
		toMedico.setCodMedico(codMedico);
		toMedico.setCodUnidade(codUnidade);
		toMedico.setCrm(crm);
		toMedico.setCro(cro);

		return toMedico;
	}


	public void cadastrarMedico(){
		
		DAOMedico dao = new DAOMedico();		
		TOMedico toMedico = getTO();
		dao.cadastrarMedico(toMedico,codLoginCadastrado); 
		this.codMedico = toMedico.getCodMedico();
		
	}
	
	public void cadastrarMedicoEspecialidade(int codMedico, String codEspecialidade){
		
		DAOMedico dao = new DAOMedico();		
		dao.cadastrarMedicoEspecialidade(codMedico,codEspecialidade);
		
	}

	public void alterarMedico(){
		DAOMedico dao = new DAOMedico();		
		TOMedico toMedico = getTO();
		dao.alterarMedico(toMedico);
	}

	public void excluirMedico(){
		DAOMedico dao = new DAOMedico();
		TOMedico toMedico = new TOMedico();
		toMedico.setCodMedico(codMedico);
		dao.excluirMedico(toMedico);
	}
	
	public void consultarMedicoCod() throws ClassNotFoundException  {

		DAOMedico dao = new DAOMedico();

		TOMedico toMedico = dao.consultarMedicoCod(codMedico);

		codMedico = toMedico.getCodMedico();
		codUnidade = toMedico.getCodUnidade();
		crm = toMedico.getCrm();
		cro = toMedico.getCro();
		super.setNumeroEndereco(toMedico.getNumeroEndereco()); 
		super.setDataCadastro(toMedico.getDataCadastro());
		super.setNome(toMedico.getNome());
		super.setCpf(toMedico.getCpf());
		super.setDataNascimento(toMedico.getDataNascimento());
		super.setEstadoCivil(toMedico.getEstadoCivil());
		super.setEmail(toMedico.getEmail());
		super.setNacionalidade(toMedico.getNacionalidade());
		super.setEndereco(toMedico.getEndereco());
		super.setCep(toMedico.getCep());
		super.setCidade(toMedico.getCidade());
		super.setUf(toMedico.getUf());
		super.setPais(toMedico.getPais());
		super.setTel1(toMedico.getTel1());
		super.setTel2(toMedico.getTel2());
		super.setCel(toMedico.getCel());
		super.setFlagAtivo(toMedico.getFlagAtivo());
	
	}
	
	
	public ArrayList<TOMedico> listarMedicos() throws ClassNotFoundException{
		ArrayList<TOMedico> lista;
		DAOMedico dao = new DAOMedico();
		lista = dao.listarMedicos();
		return lista;
	}
	
	public ArrayList<TOMedico> listarMedicos(String chave) throws ClassNotFoundException{
		ArrayList<TOMedico> lista;
		DAOMedico dao = new DAOMedico();
		lista = dao.listarMedico(chave);
		return lista;
	}	
	
	public ArrayList<TOMedico> listarMedicosCod(String codMedico) throws ClassNotFoundException{
		ArrayList<TOMedico> lista;
		DAOMedico dao = new DAOMedico();
		lista = dao.listarMedicosCod(codMedico);
		return lista;
	}	
	
	public ArrayList<TOMedico> listarMedicoLogado(String codLogin) throws ClassNotFoundException{
		ArrayList<TOMedico> lista;
		DAOMedico dao = new DAOMedico();
		lista = dao.listarMedicoLogado(codLogin);
		return lista;
	}
	
	public ArrayList<TOMedico> listarMedicoEspecialidadeUnidade(String unidadeValor, String especialidadeValor) throws ClassNotFoundException{
		ArrayList<TOMedico> lista;
		DAOMedico dao = new DAOMedico();
		//System.out.println("testeee");
		lista = dao.listarMedicoEspecialidadeUnidade(unidadeValor, especialidadeValor);
		return lista;
	}
	
	
}
