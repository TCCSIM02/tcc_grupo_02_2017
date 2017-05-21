package Model;

import java.util.ArrayList;
import java.util.Date;

import DAO.DAOPromocao;
import TO.TOPromocao;

public class ModelPromocao {

	private int codPromocao;
	private double valorPromocao;
	private Date dataInicio, dataTermino, dataCadastro;
	private String flagAtivo;
	public ModelPromocao() {
		// TODO Auto-generated constructor stub
	}
	/**
	 * @param codPromocao
	 * @param valorPromocao
	 * @param dataInicio
	 * @param dataTermino
	 * @param dataCadastro
	 * @param flagAtivo
	 */
	public ModelPromocao(int codPromocao, double valorPromocao, Date dataInicio, Date dataTermino, Date dataCadastro,
			String flagAtivo) {
		super();
		this.codPromocao = codPromocao;
		this.valorPromocao = valorPromocao;
		this.dataInicio = dataInicio;
		this.dataTermino = dataTermino;
		this.dataCadastro = dataCadastro;
		this.flagAtivo = flagAtivo;
	}
	/**
	 * @param codPromocao
	 */
	public ModelPromocao(int codPromocao) {
		super();
		this.codPromocao = codPromocao;
	}
	/**
	 * @return the codPromocao
	 */
	public int getCodPromocao() {
		return codPromocao;
	}
	/**
	 * @return the valorPromocao
	 */
	public double getValorPromocao() {
		return valorPromocao;
	}
	/**
	 * @return the dataInicio
	 */
	public Date getDataInicio() {
		return dataInicio;
	}
	/**
	 * @return the dataTermino
	 */
	public Date getDataTermino() {
		return dataTermino;
	}
	/**
	 * @return the dataCadastro
	 */
	public Date getDataCadastro() {
		return dataCadastro;
	}
	/**
	 * @return the flagAtivo
	 */
	public String getFlagAtivo() {
		return flagAtivo;
	}
	/**
	 * @param codPromocao the codPromocao to set
	 */
	public void setCodPromocao(int codPromocao) {
		this.codPromocao = codPromocao;
	}
	/**
	 * @param valorPromocao the valorPromocao to set
	 */
	public void setValorPromocao(double valorPromocao) {
		this.valorPromocao = valorPromocao;
	}
	/**
	 * @param dataInicio the dataInicio to set
	 */
	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
	}
	/**
	 * @param dataTermino the dataTermino to set
	 */
	public void setDataTermino(Date dataTermino) {
		this.dataTermino = dataTermino;
	}
	/**
	 * @param dataCadastro the dataCadastro to set
	 */
	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}
	/**
	 * @param flagAtivo the flagAtivo to set
	 */
	public void setFlagAtivo(String flagAtivo) {
		this.flagAtivo = flagAtivo;
	}

	public TOPromocao getTO(){
		
		TOPromocao toPromocao = new TOPromocao();
		
		toPromocao.setCodPromocao(codPromocao);
		toPromocao.setDataCadastro(dataCadastro);
		toPromocao.setDataInicio(dataInicio);
		toPromocao.setDataTermino(dataTermino);
		toPromocao.setFlagAtivo(flagAtivo);
		toPromocao.setValorPromocao(valorPromocao);
		
		return toPromocao;
	}
	
	public void cadastrarPromocao(){
		DAOPromocao dao = new DAOPromocao();		
		TOPromocao toPromocao = getTO();
		dao.cadastrarPromocao(toPromocao); 
		this.codPromocao = toPromocao.getCodPromocao();
	}
	
	public void alterarPromocao(){
		DAOPromocao dao = new DAOPromocao();		
		TOPromocao toPromocao = getTO();
		dao.alterarPromocao(toPromocao);		
	}
	
	public void excluirPromocao(){
		DAOPromocao dao = new DAOPromocao();		
		TOPromocao toPromocao = new TOPromocao();
		toPromocao.setCodPromocao(codPromocao);
		dao.excluirPromocao(toPromocao);
	}
	
	public void consultarPromocaoCod(){
		DAOPromocao dao = new DAOPromocao();	
		TOPromocao toPromocao = dao.consultarPromocaoCod(codPromocao);
		
		codPromocao = toPromocao.getCodPromocao();
		dataCadastro = toPromocao.getDataCadastro();
		dataInicio = toPromocao.getDataInicio();
		dataTermino = toPromocao.getDataTermino();
		flagAtivo = toPromocao.getFlagAtivo();
		valorPromocao = toPromocao.getValorPromocao();

	}
	
	public ArrayList<TOPromocao> listarPromocoes() throws ClassNotFoundException{
		ArrayList<TOPromocao> lista;
		DAOPromocao dao = new DAOPromocao();
		lista = dao.listarPromocoes();
		return lista;
	}
}
