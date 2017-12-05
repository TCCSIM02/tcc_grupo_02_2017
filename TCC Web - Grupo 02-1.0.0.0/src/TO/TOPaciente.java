package TO;

public class TOPaciente extends TOUsuario {

	private int codPaciente, codPlano;
	private String numConvenio, alergiaMedicamento, alergiaAlimentares, medicamentoContinuo, cirurgia, antecedentesPessoais, tipoSanguineo;
	private Double peso, altura;
	/**
	 * @return the codPaciente
	 */
	public int getCodPaciente() {
		return codPaciente;
	}
	
	public int getCodPlano() {
		return codPlano;
	}
	/**
	 * @return the numConvenio
	 */
	public String getNumConvenio() {
		return numConvenio;
	}
	
	public String getAlergiaMedicamento() {
		return alergiaMedicamento;
	}
	
	public String getAlergiaAlimentares() {
		return alergiaAlimentares;
	}

	public String getMedicamentoContinuo() {
		return medicamentoContinuo;
	}
	
	public String getCirurgia() {
		return cirurgia;
	}
	
	public String getAntecedentesPessoais() {
		return antecedentesPessoais;
	}
	
	public String getTipoSanguineo() {
		return tipoSanguineo;
	}
	
	public Double getPeso() {
		return peso;
	}
	
	public Double getAltura() {
		return altura;
	}	
	
	/**
	 * @param codPaciente the codPaciente to set
	 */
	public void setCodPaciente(int codPaciente) {
		this.codPaciente = codPaciente;
	}
	
	public void setCodPlano(int codPlano) {
		this.codPlano = codPlano;
	}
	/**
	 * @param numConvenio the numConvenio to set
	 */
	public void setNumConvenio(String numConvenio) {
		this.numConvenio = numConvenio;
	}

	public void setAlergiaMedicamento(String alergiaMedicamento) {
		this.alergiaMedicamento = alergiaMedicamento;
	}
	
	public void setAlergiaAlimentares(String alergiaAlimentares) {
		this.alergiaAlimentares = alergiaAlimentares;
	}
	
	public void setMedicamentoContinuo(String medicamentoContinuo) {
		this.medicamentoContinuo = medicamentoContinuo;
	}
	
	public void setCirurgia(String cirurgia) {
		this.cirurgia = cirurgia;
	}
	
	public void setAntecedentesPessoais(String antecedentesPessoais) {
		this.antecedentesPessoais = antecedentesPessoais;
	}
	
	public void setTipoSanguineo(String tipoSanguineo) {
		this.tipoSanguineo = tipoSanguineo;
	}
	
	public void setPeso(Double peso) {
		this.peso = peso;
	}
	
	public void setAltura(Double altura) {
		this.altura = altura;
	}
	
}
