package DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import ConnectionFactory.FabricaConexao;
import TO.TOPaciente;
import TO.TOPlano;

public class DAOPaciente {
	
	public void cadastrarPaciente(TOPaciente toPaciente){
		String sqlInsert = "INSERT INTO tcc.paciente(numeroEndereco,numConvenio,nomePaciente,cPF,dataNascimento,email,estadoCivil,nacionalidade,endereco,cEP,cidade,uF,pais,tel1,tel2,cel,dataCadastro) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,current_timestamp())";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = FabricaConexao.getConexao(); 
				PreparedStatement stm = conn.prepareStatement(sqlInsert);) {

			java.util.Date dataUtil = new java.util.Date();
			//SimpleDateFormat inputdate = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

			//String strDate = inputdate.format(dataUtil);
			
			//long longDate = Long.valueOf(strDate);
			
			java.sql.Date dataSql = new java.sql.Date(dataUtil.getTime());
			//java.sql.Date dataSql = new java.sql.Date(longDate);
						
			
			stm.setString(1,toPaciente.getNumeroEndereco() );
			stm.setString(2,toPaciente.getNumConvenio());
			//stm.setDate(2,toPaciente.getDataCadastro() ) ;
			stm.setString(3,toPaciente.getNome());
			stm.setString(4,toPaciente.getCpf());
			stm.setDate(5,(Date) toPaciente.getDataNascimento() );
			stm.setString(6,toPaciente.getEmail()) ;
			stm.setString(7,toPaciente.getEstadoCivil()) ;
			stm.setString(8,toPaciente.getNacionalidade());
			stm.setString(9,toPaciente.getEndereco());
			stm.setString(10,toPaciente.getCep()) ;
			stm.setString(11,toPaciente.getCidade() );
			stm.setString(12,toPaciente.getUf()) ;
			stm.setString(13,toPaciente.getPais() );
			stm.setString(14,toPaciente.getTel1()); 
			stm.setString(15,toPaciente.getTel2()); 
			stm.setString(16,toPaciente.getCel()) ;
			//stm.setString(15,"1");
			
			/*TOPaciente*/
	
			//stm.setString(4,toPaciente.getFlagAtivo());
			//stm.setDate(5,dataSql);
			
			stm.execute();
			
			String sqlSelect = "SELECT LAST_INSERT_ID()";
			
			try(PreparedStatement stm1 = conn.prepareStatement(sqlSelect);
					ResultSet rs = stm1.executeQuery();){
					if(rs.next()){
						toPaciente.setCodPaciente(rs.getInt(1));
					}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/**/
	public void cadastrarPaciente(TOPaciente toPaciente, int codLoginCadastrado){
		String sqlInsert = "INSERT INTO tcc.paciente(numeroEndereco,numConvenio,nomePaciente,cPF,dataNascimento,email,estadoCivil,nacionalidade,endereco,cEP,cidade,uF,pais,tel1,tel2,cel,dataCadastro, codLogin, alergiaMedicamento, alergiaAlimentares, peso, altura, medicamentoContinuo, cirurgia, antecedentesPessoais, tipoSanguineo, codPlano) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,current_timestamp(),?,?,?,?,?,?,?,?,?,?)";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = FabricaConexao.getConexao(); 
				PreparedStatement stm = conn.prepareStatement(sqlInsert);) {
			
			stm.setString(1,toPaciente.getNumeroEndereco() );
			stm.setString(2,toPaciente.getNumConvenio());
			stm.setString(3,toPaciente.getNome());
			stm.setString(4,toPaciente.getCpf());
			stm.setDate(5,(Date) toPaciente.getDataNascimento() );
			stm.setString(6,toPaciente.getEmail()) ;
			stm.setString(7,toPaciente.getEstadoCivil()) ;
			stm.setString(8,toPaciente.getNacionalidade());
			stm.setString(9,toPaciente.getEndereco());
			stm.setString(10,toPaciente.getCep()) ;
			stm.setString(11,toPaciente.getCidade() );
			stm.setString(12,toPaciente.getUf()) ;
			stm.setString(13,toPaciente.getPais() );
			stm.setString(14,toPaciente.getTel1()); 
			stm.setString(15,toPaciente.getTel2()); 
			stm.setString(16,toPaciente.getCel());
			stm.setInt(17,codLoginCadastrado);			
			stm.setString(18,toPaciente.getAlergiaMedicamento());
			stm.setString(19,toPaciente.getAlergiaAlimentares());
			stm.setDouble(20,toPaciente.getPeso());
			stm.setDouble(21,toPaciente.getAltura());			
			stm.setString(22,toPaciente.getMedicamentoContinuo());
			stm.setString(23,toPaciente.getCirurgia());
			stm.setString(24,toPaciente.getAntecedentesPessoais());
			stm.setString(25,toPaciente.getTipoSanguineo());
			stm.setInt(26,toPaciente.getCodPlano());

			
			stm.execute();
			
			String sqlSelect = "SELECT LAST_INSERT_ID()";
			
			try(PreparedStatement stm1 = conn.prepareStatement(sqlSelect);
					ResultSet rs = stm1.executeQuery();){
					if(rs.next()){
						toPaciente.setCodPaciente(rs.getInt(1));
					}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	
	
	public void alterarPaciente(TOPaciente toPaciente){
		String sqlUpdate = "UPDATE tcc.paciente SET numeroEndereco = ?, numConvenio = ?, nomePaciente = ?, cPF = ?, dataNascimento = ?, email = ?, estadoCivil = ?, nacionalidade = ?, endereco = ?, cEP = ?, cidade = ?, uF = ?, pais = ?, tel1 = ?, tel2 = ?, cel = ?, alergiaMedicamento = ?, alergiaAlimentares = ?, peso = ?, altura = ?, medicamentoContinuo = ?, cirurgia = ?, antecedentesPessoais = ?, tipoSanguineo = ?, codPlano= ? WHERE codPaciente = ?";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = FabricaConexao.getConexao(); 
			PreparedStatement stm = conn.prepareStatement(sqlUpdate);) {		
			
			stm.setString(1,toPaciente.getNumeroEndereco() );
			stm.setString(2,toPaciente.getNumConvenio());
			//stm.setDate(2,toPaciente.getDataCadastro() ) ;
			stm.setString(3,toPaciente.getNome());
			stm.setString(4,toPaciente.getCpf());
			stm.setDate(5,(Date) toPaciente.getDataNascimento() );
			stm.setString(6,toPaciente.getEmail()) ;
			stm.setString(7,toPaciente.getEstadoCivil()) ;
			stm.setString(8,toPaciente.getNacionalidade());
			stm.setString(9,toPaciente.getEndereco());
			stm.setString(10,toPaciente.getCep()) ;
			stm.setString(11,toPaciente.getCidade() );
			stm.setString(12,toPaciente.getUf()) ;
			stm.setString(13,toPaciente.getPais() );
			stm.setString(14,toPaciente.getTel1()); 
			stm.setString(15,toPaciente.getTel2()); 
			stm.setString(16,toPaciente.getCel());					
			stm.setString(17,toPaciente.getAlergiaMedicamento());
			stm.setString(18,toPaciente.getAlergiaAlimentares());
			stm.setDouble(19,toPaciente.getPeso());
			stm.setDouble(20,toPaciente.getAltura());
			stm.setString(21,toPaciente.getMedicamentoContinuo());
			stm.setString(22,toPaciente.getCirurgia());
			stm.setString(23,toPaciente.getAntecedentesPessoais());
			stm.setString(24,toPaciente.getTipoSanguineo());
			stm.setInt(25,toPaciente.getCodPlano());	
			stm.setInt(26,toPaciente.getCodPaciente());	

			System.out.println(toPaciente.getCodPaciente());
			
			stm.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	public void excluirPaciente(TOPaciente toPaciente){
		String sqlDelete = "UPDATE tcc.paciente SET flagAtivo = 0 WHERE codPaciente = ?";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = FabricaConexao.getConexao(); 
				PreparedStatement stm = conn.prepareStatement(sqlDelete);) {
			
			stm.setInt(1, toPaciente.getCodPaciente());
			
			stm.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	public TOPaciente consultarPacienteCod(int codPacienteBusca){
		TOPaciente toPaciente = new TOPaciente();
		toPaciente.setCodPaciente(codPacienteBusca);
		String sqlSelect = "SELECT * FROM tcc.paciente where codPaciente = ? and flagAtivo = 1";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = FabricaConexao.getConexao(); 
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			stm.setInt(1, codPacienteBusca);
			try (ResultSet rs = stm.executeQuery();) {
				if (rs.next()) {
					
					//toPaciente.setCodPaciente(rs.getInt("codPaciente"));
					toPaciente.setCodPlano(rs.getInt("codPlano"));
					toPaciente.setNumeroEndereco(rs.getString("numeroEndereco"));
					toPaciente.setDataCadastro(rs.getDate("dataCadastro"));
					toPaciente.setNome(rs.getString("nomePaciente"));
					toPaciente.setCpf(rs.getString("cPF"));
					toPaciente.setDataNascimento(rs.getDate("dataNascimento"));
					toPaciente.setEstadoCivil(rs.getString("estadoCivil"));
					toPaciente.setNacionalidade(rs.getString("nacionalidade"));
					toPaciente.setEndereco(rs.getString("endereco"));
					toPaciente.setCep(rs.getString("cEP"));
					toPaciente.setCidade(rs.getString("cidade"));
					toPaciente.setUf(rs.getString("uF"));
					toPaciente.setPais(rs.getString("pais"));
					toPaciente.setTel1(rs.getString("tel1"));
					toPaciente.setTel2(rs.getString("tel2"));
					toPaciente.setCel(rs.getString("cel"));
					toPaciente.setFlagAtivo(rs.getString("flagAtivo"));
					toPaciente.setNumConvenio(rs.getString("numConvenio"));
					toPaciente.setEmail(rs.getString("email"));
					toPaciente.setAlergiaMedicamento(rs.getString("alergiaMedicamento"));
					toPaciente.setAlergiaAlimentares(rs.getString("alergiaAlimentares"));
					toPaciente.setPeso(rs.getDouble("peso"));
					toPaciente.setAltura(rs.getDouble("altura"));
					toPaciente.setMedicamentoContinuo(rs.getString("medicamentoContinuo"));
					toPaciente.setCirurgia(rs.getString("cirurgia"));
					toPaciente.setAntecedentesPessoais(rs.getString("antecedentesPessoais"));
					toPaciente.setTipoSanguineo(rs.getString("tipoSanguineo"));
				
					
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}
		return toPaciente;
	}
	
	public ArrayList<TOPaciente> listarPacientes(){
		TOPaciente toPaciente;
		ArrayList<TOPaciente> lista = new ArrayList<>();
		String sqlSelect = "SELECT * FROM tcc.paciente where flagAtivo = 1 order by codPaciente desc";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = FabricaConexao.getConexao(); 
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			try (ResultSet rs = stm.executeQuery();) {
				while(rs.next()) {
					toPaciente = new TOPaciente();
								
					toPaciente.setCodPaciente(rs.getInt("codPaciente"));
					toPaciente.setNumeroEndereco(rs.getString("numeroEndereco"));
					toPaciente.setDataCadastro(rs.getDate("dataCadastro"));
					toPaciente.setNome(rs.getString("nomePaciente"));
					toPaciente.setCpf(rs.getString("cPF"));
					toPaciente.setDataNascimento(rs.getDate("dataNascimento"));
					toPaciente.setEstadoCivil(rs.getString("estadoCivil"));
					toPaciente.setNacionalidade(rs.getString("nacionalidade"));
					toPaciente.setEndereco(rs.getString("endereco"));
					toPaciente.setCep(rs.getString("cEP"));
					toPaciente.setCidade(rs.getString("cidade"));
					toPaciente.setUf(rs.getString("uF"));
					toPaciente.setPais(rs.getString("pais"));
					toPaciente.setTel1(rs.getString("tel1"));
					toPaciente.setTel2(rs.getString("tel2"));
					toPaciente.setCel(rs.getString("cel"));
					toPaciente.setFlagAtivo(rs.getString("flagAtivo"));
					toPaciente.setNumConvenio(rs.getString("numConvenio"));
					toPaciente.setEmail(rs.getString("email"));					
					toPaciente.setAlergiaMedicamento(rs.getString("alergiaMedicamento"));
					toPaciente.setAlergiaAlimentares(rs.getString("alergiaAlimentares"));
					toPaciente.setPeso(rs.getDouble("peso"));
					toPaciente.setAltura(rs.getDouble("altura"));
					toPaciente.setMedicamentoContinuo(rs.getString("medicamentoContinuo"));
					toPaciente.setCirurgia(rs.getString("cirurgia"));
					toPaciente.setAntecedentesPessoais(rs.getString("antecedentesPessoais"));
					toPaciente.setTipoSanguineo(rs.getString("tipoSanguineo"));
									
					lista.add(toPaciente);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}
		return lista;
	}
	
	
	public ArrayList<TOPaciente> listarPaciente(String chave){
		TOPaciente toPaciente;
		ArrayList<TOPaciente> lista = new ArrayList<>();
							
		String sqlSelect = "SELECT * FROM  TCC.PACIENTE WHERE UPPER(nomePaciente) LIKE ? and flagAtivo = 1";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = FabricaConexao.getConexao(); 
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
				stm.setString(1, "%" + chave.toUpperCase() + "%");
			try (ResultSet rs = stm.executeQuery();) {
				while(rs.next()) {
					toPaciente = new TOPaciente();
					
					toPaciente.setCodPaciente(rs.getInt("codPaciente"));
					toPaciente.setNumeroEndereco(rs.getString("numeroEndereco"));
					toPaciente.setDataCadastro(rs.getDate("dataCadastro"));
					toPaciente.setNome(rs.getString("nomePaciente"));
					toPaciente.setCpf(rs.getString("cPF"));
					toPaciente.setDataNascimento(rs.getDate("dataNascimento"));
					toPaciente.setEstadoCivil(rs.getString("estadoCivil"));
					toPaciente.setNacionalidade(rs.getString("nacionalidade"));
					toPaciente.setEndereco(rs.getString("endereco"));
					toPaciente.setCep(rs.getString("cEP"));
					toPaciente.setCidade(rs.getString("cidade"));
					toPaciente.setUf(rs.getString("uF"));
					toPaciente.setPais(rs.getString("pais"));
					toPaciente.setTel1(rs.getString("tel1"));
					toPaciente.setTel2(rs.getString("tel2"));
					toPaciente.setCel(rs.getString("cel"));
					toPaciente.setFlagAtivo(rs.getString("flagAtivo"));
					toPaciente.setNumConvenio(rs.getString("numConvenio"));
					toPaciente.setEmail(rs.getString("email"));					
					toPaciente.setAlergiaMedicamento(rs.getString("alergiaMedicamento"));
					toPaciente.setAlergiaAlimentares(rs.getString("alergiaAlimentares"));
					toPaciente.setPeso(rs.getDouble("peso"));
					toPaciente.setAltura(rs.getDouble("altura"));
					toPaciente.setMedicamentoContinuo(rs.getString("medicamentoContinuo"));
					toPaciente.setCirurgia(rs.getString("cirurgia"));
					toPaciente.setAntecedentesPessoais(rs.getString("antecedentesPessoais"));
					toPaciente.setTipoSanguineo(rs.getString("tipoSanguineo"));
									
					lista.add(toPaciente);
				}
			} catch (SQLException e) {				
				e.printStackTrace(); 
			}
		} catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}
		return lista;
	}	
	
	public ArrayList<TOPaciente> listarPacientesCod(String codPaciente){
		TOPaciente toPaciente;
		ArrayList<TOPaciente> lista = new ArrayList<>();
							
		String sqlSelect = "SELECT * FROM  TCC.PACIENTE WHERE codPaciente LIKE ? and flagAtivo = 1";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = FabricaConexao.getConexao(); 
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
				stm.setString(1,codPaciente);
			try (ResultSet rs = stm.executeQuery();) {
				while(rs.next()) {
					toPaciente = new TOPaciente();
					
					toPaciente.setCodPaciente(rs.getInt("codPaciente"));
					toPaciente.setNumeroEndereco(rs.getString("numeroEndereco"));
					toPaciente.setDataCadastro(rs.getDate("dataCadastro"));
					toPaciente.setNome(rs.getString("nomePaciente"));
					toPaciente.setCpf(rs.getString("cPF"));
					toPaciente.setDataNascimento(rs.getDate("dataNascimento"));
					toPaciente.setEstadoCivil(rs.getString("estadoCivil"));
					toPaciente.setNacionalidade(rs.getString("nacionalidade"));
					toPaciente.setEndereco(rs.getString("endereco"));
					toPaciente.setCep(rs.getString("cEP"));
					toPaciente.setCidade(rs.getString("cidade"));
					toPaciente.setUf(rs.getString("uF"));
					toPaciente.setPais(rs.getString("pais"));
					toPaciente.setTel1(rs.getString("tel1"));
					toPaciente.setTel2(rs.getString("tel2"));
					toPaciente.setCel(rs.getString("cel"));
					toPaciente.setFlagAtivo(rs.getString("flagAtivo"));
					toPaciente.setNumConvenio(rs.getString("numConvenio"));
					toPaciente.setEmail(rs.getString("email"));					
					toPaciente.setAlergiaMedicamento(rs.getString("alergiaMedicamento"));
					toPaciente.setAlergiaAlimentares(rs.getString("alergiaAlimentares"));
					toPaciente.setPeso(rs.getDouble("peso"));
					toPaciente.setAltura(rs.getDouble("altura"));
					toPaciente.setMedicamentoContinuo(rs.getString("medicamentoContinuo"));
					toPaciente.setCirurgia(rs.getString("cirurgia"));
					toPaciente.setAntecedentesPessoais(rs.getString("antecedentesPessoais"));
					toPaciente.setTipoSanguineo(rs.getString("tipoSanguineo"));
									
					lista.add(toPaciente);
				}
			} catch (SQLException e) {				
				e.printStackTrace(); 
			}
		} catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}
		return lista;
	}	
	
	
	
	
}
