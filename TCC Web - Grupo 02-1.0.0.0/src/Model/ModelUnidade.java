/**
 * 
 */
package Model;

import java.util.ArrayList;
import java.util.Date;

import DAO.DAOUnidade;
import TO.TOUnidade;

/**
 * @author Nilton
 *
 */
public class ModelUnidade {

	private int codUnidade, numeroEndereco;
	/**
	 * @return the numeroEndereco
	 */
	public int getNumeroEndereco() {
		return numeroEndereco;
	}

	/**
	 * @param numeroEndereco the numeroEndereco to set
	 */
	public void setNumeroEndereco(int numeroEndereco) {
		this.numeroEndereco = numeroEndereco;
	}

	private String razaoSocial, nomeFantasia, cnpj, nomeRede, endereco, logradouro, cep, cidade, uf, pais, representante, tel1, tel2, cel, flagAtivo;
	private Date dataCadastro;
	
	public ModelUnidade() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param codUnidade
	 */
	public ModelUnidade(int codUnidade) {
		this.codUnidade = codUnidade;
	}

	/**
	 * @return the codUnidade
	 */
	public int getCodUnidade() {
		return codUnidade;
	}

	/**
	 * @return the razaoSocial
	 */
	public String getRazaoSocial() {
		return razaoSocial;
	}

	/**
	 * @return the nomeFantasia
	 */
	public String getNomeFantasia() {
		return nomeFantasia;
	}

	/**
	 * @return the cnpj
	 */
	public String getCnpj() {
		return cnpj;
	}

	/**
	 * @return the nomeRede
	 */
	public String getNomeRede() {
		return nomeRede;
	}

	/**
	 * @return the endereco
	 */
	public String getEndereco() {
		return endereco;
	}

	/**
	 * @return the logradouro
	 */
	public String getLogradouro() {
		return logradouro;
	}

	/**
	 * @return the cep
	 */
	public String getCep() {
		return cep;
	}

	/**
	 * @return the cidade
	 */
	public String getCidade() {
		return cidade;
	}

	/**
	 * @return the uf
	 */
	public String getUf() {
		return uf;
	}

	/**
	 * @return the pais
	 */
	public String getPais() {
		return pais;
	}

	/**
	 * @return the representante
	 */
	public String getRepresentante() {
		return representante;
	}

	/**
	 * @return the tel1
	 */
	public String getTel1() {
		return tel1;
	}

	/**
	 * @return the tel2
	 */
	public String getTel2() {
		return tel2;
	}

	/**
	 * @return the cel
	 */
	public String getCel() {
		return cel;
	}

	/**
	 * @return the flagAtivo
	 */
	public String getFlagAtivo() {
		return flagAtivo;
	}

	/**
	 * @return the dataCadastro
	 */
	public Date getDataCadastro() {
		return dataCadastro;
	}

	/**
	 * @param codUnidade the codUnidade to set
	 */
	public void setCodUnidade(int codUnidade) {
		this.codUnidade = codUnidade;
	}

	/**
	 * @param razaoSocial the razaoSocial to set
	 */
	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}

	/**
	 * @param nomeFantasia the nomeFantasia to set
	 */
	public void setNomeFantasia(String nomeFantasia) {
		this.nomeFantasia = nomeFantasia;
	}

	/**
	 * @param cnpj the cnpj to set
	 */
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	/**
	 * @param nomeRede the nomeRede to set
	 */
	public void setNomeRede(String nomeRede) {
		this.nomeRede = nomeRede;
	}

	/**
	 * @param endereco the endereco to set
	 */
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	/**
	 * @param logradouro the logradouro to set
	 */
	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	/**
	 * @param cep the cep to set
	 */
	public void setCep(String cep) {
		this.cep = cep;
	}

	/**
	 * @param cidade the cidade to set
	 */
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	/**
	 * @param uf the uf to set
	 */
	public void setUf(String uf) {
		this.uf = uf;
	}

	/**
	 * @param pais the pais to set
	 */
	public void setPais(String pais) {
		this.pais = pais;
	}

	/**
	 * @param representante the representante to set
	 */
	public void setRepresentante(String representante) {
		this.representante = representante;
	}

	/**
	 * @param tel1 the tel1 to set
	 */
	public void setTel1(String tel1) {
		this.tel1 = tel1;
	}

	/**
	 * @param tel2 the tel2 to set
	 */
	public void setTel2(String tel2) {
		this.tel2 = tel2;
	}

	/**
	 * @param cel the cel to set
	 */
	public void setCel(String cel) {
		this.cel = cel;
	}

	/**
	 * @param flagAtivo the flagAtivo to set
	 */
	public void setFlagAtivo(String flagAtivo) {
		this.flagAtivo = flagAtivo;
	}

	/**
	 * @param dataCadastro the dataCadastro to set
	 */
	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}
	
	public TOUnidade getTO(){
		
		TOUnidade toUnidade = new TOUnidade();
		
		toUnidade.setCel(cel);
		toUnidade.setCep(cep);
		toUnidade.setCidade(cidade);
		toUnidade.setCnpj(cnpj);
		toUnidade.setCodUnidade(codUnidade);
		toUnidade.setDataCadastro(dataCadastro);
		toUnidade.setEndereco(endereco);
		toUnidade.setFlagAtivo(flagAtivo);
		toUnidade.setLogradouro(logradouro);
		toUnidade.setNomeFantasia(nomeFantasia);
		toUnidade.setNomeRede(nomeRede);
		toUnidade.setNumeroEndereco(numeroEndereco);
		toUnidade.setPais(pais);
		toUnidade.setRazaoSocial(razaoSocial);
		toUnidade.setRepresentante(representante);
		toUnidade.setTel1(tel1);
		toUnidade.setTel2(tel2);
		toUnidade.setUf(uf);
		
		return toUnidade;
		
	}
	
	public void cadastrarUnidade(){
		
		DAOUnidade dao = new DAOUnidade();		
		TOUnidade toUnidade = getTO();
		dao.cadastrarUnidade(toUnidade); 
		this.codUnidade = toUnidade.getCodUnidade();
		
	}
	
	public void alterarUnidade(){
		DAOUnidade dao = new DAOUnidade();		
		TOUnidade toUnidade = getTO();
		dao.alterarUnidade(toUnidade);		
	}
	
	public void excluirUnidade(){
		DAOUnidade dao = new DAOUnidade();		
		TOUnidade toUnidade = new TOUnidade();
		toUnidade.setCodUnidade(codUnidade);
		dao.excluirUnidade(toUnidade);
	}
	
	public void consultarUnidadeCod() throws ClassNotFoundException  {
		DAOUnidade dao = new DAOUnidade();	

		TOUnidade toUnidade = dao.consultarUnidadeCod(codUnidade);
		
		cel = toUnidade.getCel();
		cep = toUnidade.getCep();
		cidade = toUnidade.getCidade();
		cnpj = toUnidade.getCnpj();
		codUnidade = toUnidade.getCodUnidade();
		dataCadastro = toUnidade.getDataCadastro();
		endereco = toUnidade.getEndereco();
		flagAtivo = toUnidade.getFlagAtivo();
		logradouro = toUnidade.getLogradouro();
		nomeFantasia = toUnidade.getNomeFantasia();
		nomeRede = toUnidade.getNomeRede();
		numeroEndereco = toUnidade.getNumeroEndereco();
		pais = toUnidade.getPais();
		razaoSocial = toUnidade.getRazaoSocial();
		representante = toUnidade.getRepresentante();
		tel1 = toUnidade.getTel1();
		tel2 = toUnidade.getTel2();
		uf = toUnidade.getUf();

	}
	
	public ArrayList<TOUnidade> listarUnidades() throws ClassNotFoundException{
		ArrayList<TOUnidade> lista;
		DAOUnidade dao = new DAOUnidade();	
		lista = dao.listarUnidades();
		return lista;
	}
	public ArrayList<TOUnidade> listarUnidades(String chave) throws ClassNotFoundException{
		ArrayList<TOUnidade> lista;
		DAOUnidade dao = new DAOUnidade();	
		lista = dao.listarUnidades(chave);
		return lista;
	}
}
