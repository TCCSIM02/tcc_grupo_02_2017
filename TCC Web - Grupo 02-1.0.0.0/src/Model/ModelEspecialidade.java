package Model;

import java.util.ArrayList;

import DAO.DAOEspecialidade;
import TO.TOEspecialidade;



public class ModelEspecialidade {

	private int codEspecialidade;
	private String flagAtivo, descricao, especialidade;
	
	public ModelEspecialidade() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param codEspecialidade
	 */
	public ModelEspecialidade(int codEspecialidade) {
		this.codEspecialidade = codEspecialidade;
	}
	
	/**
	 * @param codEspecialidade
	 * @param flagAtivo
	 * @param descricao
	 */
	public ModelEspecialidade(int codEspecialidade,String especialidade, String flagAtivo, String descricao) {
		this.codEspecialidade = codEspecialidade;
		this.flagAtivo = flagAtivo;
		this.descricao = descricao;
		this.especialidade = especialidade;
	}

	/**
	 * @return the codEspecialidade
	 */
	public int getCodEspecialidade() {
		return codEspecialidade;
	}

	/**
	 * @return the flagAtivo
	 */
	public String getFlagAtivo() {
		return flagAtivo;
	}

	/**
	 * @return the descricao
	 */
	public String getDescricao() {
		return descricao;
	}

	public String getEspecialidade() {
		return especialidade;
	}

	/**
	 * @param codEspecialidade the codEspecialidade to set
	 */
	public void setCodEspecialidade(int codEspecialidade) {
		this.codEspecialidade = codEspecialidade;
	}

	/**
	 * @param flagAtivo the flagAtivo to set
	 */
	public void setFlagAtivo(String flagAtivo) {
		this.flagAtivo = flagAtivo;
	}

	/**
	 * @param descricao the descricao to set
	 */
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public void setEspecialidade(String especialidade) {
		this.especialidade = especialidade;
	}
	
	public TOEspecialidade getTO(){
		
		TOEspecialidade toEspecialidade = new TOEspecialidade();
		
		toEspecialidade.setCodEspecialidade(codEspecialidade);
		toEspecialidade.setDescricao(descricao);
		toEspecialidade.setEspecialidade(especialidade);
		toEspecialidade.setFlagAtivo(flagAtivo);
		
		return toEspecialidade;
	}
	
	public void cadastrarEspecialidade(){
		DAOEspecialidade dao = new DAOEspecialidade();		
		TOEspecialidade toEspecialidade = getTO();
		dao.cadastrarEspecialidade(toEspecialidade); 
		this.codEspecialidade = toEspecialidade.getCodEspecialidade();
	}

	public void consultarEspecialidadeCod()throws ClassNotFoundException {
		
		DAOEspecialidade dao = new DAOEspecialidade();	
		TOEspecialidade toEspecialidade = dao.consultarEspecialidadeCod(codEspecialidade);
		
		codEspecialidade = toEspecialidade.getCodEspecialidade();
		descricao =  toEspecialidade.getDescricao();
		flagAtivo = toEspecialidade.getFlagAtivo();
		especialidade = toEspecialidade.getEspecialidade();
	}
	
	public ArrayList<TOEspecialidade> listarEspecialidades() throws ClassNotFoundException{
		ArrayList<TOEspecialidade> lista;
		DAOEspecialidade dao = new DAOEspecialidade();
		lista = dao.listarEspecialidades();
		return lista;
	}
	
	public ArrayList<TOEspecialidade> listarEspecialidadesCod(String codEspecialidade) throws ClassNotFoundException{
		ArrayList<TOEspecialidade> lista;
		DAOEspecialidade dao = new DAOEspecialidade();
		lista = dao.listarEspecialidadesCod(codEspecialidade);
		return lista;
	}
	
	
	public ArrayList<TOEspecialidade> listarEspecialidades(String chave) throws ClassNotFoundException{
		ArrayList<TOEspecialidade> lista;
		DAOEspecialidade dao = new DAOEspecialidade();
		lista = dao.listarEspecialidades(chave);
		return lista;
	}	

}
