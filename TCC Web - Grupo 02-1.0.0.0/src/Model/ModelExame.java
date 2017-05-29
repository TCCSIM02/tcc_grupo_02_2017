package Model;



import java.util.ArrayList;

import DAO.DAOExame;
import TO.TOExame;

public class ModelExame {

	private int codExame;
	private double valorExame;
	private String descricao, resultadoExame;
	
	/**
	 * @param codExame
	 * @param valorExame
	 * @param descricao
	 * @param resultadoExame
	 */
	public ModelExame(int codExame, double valorExame, String descricao, String resultadoExame) {
		this.codExame = codExame;
		this.valorExame = valorExame;
		this.descricao = descricao;
		this.resultadoExame = resultadoExame;
	}

	/**
	 * @param codExame
	 */
	public ModelExame(int codExame) {
		this.codExame = codExame;
	}

	public ModelExame() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return the codExame
	 */
	public int getCodExame() {
		return codExame;
	}

	/**
	 * @return the valorExame
	 */
	public double getValorExame() {
		return valorExame;
	}

	/**
	 * @return the descricao
	 */
	public String getDescricao() {
		return descricao;
	}

	/**
	 * @return the resultadoExame
	 */
	public String getResultadoExame() {
		return resultadoExame;
	}

	/**
	 * @param codExame the codExame to set
	 */
	public void setCodExame(int codExame) {
		this.codExame = codExame;
	}

	/**
	 * @param valorExame the valorExame to set
	 */
	public void setValorExame(double valorExame) {
		this.valorExame = valorExame;
	}

	/**
	 * @param descricao the descricao to set
	 */
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	/**
	 * @param resultadoExame the resultadoExame to set
	 */
	public void setResultadoExame(String resultadoExame) {
		this.resultadoExame = resultadoExame;
	}
	
	public TOExame getTO(){
		
		TOExame toExame = new TOExame();
		
		toExame.setCodExame(codExame);
		toExame.setDescricao(descricao);
		toExame.setResultadoExame(resultadoExame);
		toExame.setValorExame(valorExame);
		
		return toExame;
	}
	
	public void cadastrarExame(){
		
		DAOExame dao = new DAOExame();		
		TOExame toExame = getTO();
		dao.cadastrarExame(toExame); 
		this.codExame = toExame.getCodExame();
		
	}
	
	public void alterarExame(){
		DAOExame dao = new DAOExame();		
		TOExame toExame = getTO();
		dao.alterarExame(toExame);		
	}
	
	public void excluirExame(){
		DAOExame dao = new DAOExame();
		TOExame toExame = new TOExame();
		toExame.setCodExame(codExame);
		dao.excluirExame(toExame);
	}
	
	/*	consulta por id	*/
	public void consultarExameCod() throws ClassNotFoundException  {

		DAOExame dao = new DAOExame();

		TOExame toExame = dao.consultarExameCod(codExame);

		codExame = toExame.getCodExame();	
		descricao = toExame.getDescricao();
		resultadoExame = toExame.getResultadoExame();
		valorExame = toExame.getValorExame();
	}
	
	public ArrayList<TOExame> listarExames() throws ClassNotFoundException{
		ArrayList<TOExame> lista;
		DAOExame dao = new DAOExame();
		lista = dao.listarExames();
		return lista;
	}
	public ArrayList<TOExame> listarExames(String chave) throws ClassNotFoundException{
		ArrayList<TOExame> lista;
		DAOExame dao = new DAOExame();
		lista = dao.listarExames(chave);
		return lista;
	}	

	
	

}
