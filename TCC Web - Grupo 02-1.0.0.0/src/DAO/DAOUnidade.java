package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import TO.TOUnidade;
import ConnectionFactory.FabricaConexao;

public class DAOUnidade {
	
	public void cadastrarUnidade(TOUnidade toUnidade){
		String sqlInsert = "INSERT INTO tcc.unidade (razaoSocial,nomeFantasia,cNPJ,nomeRede,endereco,cEP,cidade,uF,pais,numeroEndereco,representante,tel1,tel2,cel,dataCadastro,latitude,longitude) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,current_timestamp(),?,?)";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = FabricaConexao.getConexao(); 
				PreparedStatement stm = conn.prepareStatement(sqlInsert);) {

			stm.setString(1,toUnidade.getRazaoSocial());
			stm.setString(2,toUnidade.getNomeFantasia());
			stm.setString(3,toUnidade.getCnpj());
			stm.setString(4,toUnidade.getNomeRede());
			stm.setString(5,toUnidade.getEndereco());
			stm.setString(6,toUnidade.getCep());
			stm.setString(7,toUnidade.getCidade());
			stm.setString(8,toUnidade.getUf());
			stm.setString(9,toUnidade.getPais());
			stm.setString(10,toUnidade.getNumeroEndereco());
			stm.setString(11,toUnidade.getRepresentante());
			stm.setString(12,toUnidade.getTel1());
			stm.setString(13,toUnidade.getTel2());
			stm.setString(14,toUnidade.getCel());
			stm.setDouble(15,toUnidade.getLatitude());	
			stm.setDouble(16,toUnidade.getLongitude());	

			stm.execute();
			
			String sqlSelect = "SELECT LAST_INSERT_ID()";
			
			try(PreparedStatement stm1 = conn.prepareStatement(sqlSelect);
					ResultSet rs = stm1.executeQuery();){
					if(rs.next()){
						toUnidade.setCodUnidade(rs.getInt(1));
					}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void alterarUnidade(TOUnidade toUnidade){
		String sqlUpdate = "UPDATE tcc.unidade SET razaoSocial = ?, nomeFantasia = ?, cNPJ = ?, nomeRede = ?, endereco = ?, cEP = ?, cidade = ?, uF = ?, pais = ?, numeroEndereco = ?, representante = ?, tel1 = ?, tel2 = ?, cel = ?, latitude = ?, longitude = ? WHERE codUnidade = ?";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = FabricaConexao.getConexao(); 
			PreparedStatement stm = conn.prepareStatement(sqlUpdate);) {
			
			stm.setString(1,toUnidade.getRazaoSocial());
			stm.setString(2,toUnidade.getNomeFantasia());
			stm.setString(3,toUnidade.getCnpj());
			stm.setString(4,toUnidade.getNomeRede());
			stm.setString(5,toUnidade.getEndereco());
			stm.setString(6,toUnidade.getCep());
			stm.setString(7,toUnidade.getCidade());
			stm.setString(8,toUnidade.getUf());
			stm.setString(9,toUnidade.getPais());
			stm.setString(10,toUnidade.getNumeroEndereco());
			stm.setString(11,toUnidade.getRepresentante());
			stm.setString(12,toUnidade.getTel1());
			stm.setString(13,toUnidade.getTel2());
			stm.setString(14,toUnidade.getCel());
			stm.setDouble(15,toUnidade.getLatitude());
			stm.setDouble(16,toUnidade.getLongitude());
			stm.setInt(17,toUnidade.getCodUnidade());	
			
			stm.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void excluirUnidade(TOUnidade toUnidade){
		String sqlDelete = "UPDATE tcc.unidade SET flagAtivo = 0 Where codUnidade = ?";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = FabricaConexao.getConexao(); 
				PreparedStatement stm = conn.prepareStatement(sqlDelete);) {
			
			stm.setInt(1, toUnidade.getCodUnidade());
			
			stm.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}		
	}
	
	public TOUnidade consultarUnidadeCod(int codUnidadeBusca){
		TOUnidade toUnidade = new TOUnidade();
		toUnidade.setCodUnidade(codUnidadeBusca);
		String sqlSelect = "SELECT * FROM tcc.unidade where codUnidade = ? and flagAtivo = 1";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = FabricaConexao.getConexao(); 
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			stm.setInt(1, codUnidadeBusca);
			try (ResultSet rs = stm.executeQuery();) {
				if (rs.next()) {
					
					//toUnidade.setCodUnidade(codUnidadeBusca);
					toUnidade.setRazaoSocial(rs.getString("razaoSocial"));
					toUnidade.setNomeFantasia(rs.getString("nomeFantasia"));
					toUnidade.setCnpj(rs.getString("cNPJ"));
					toUnidade.setNomeRede(rs.getString("nomeRede"));
					toUnidade.setEndereco(rs.getString("endereco"));
					toUnidade.setCep(rs.getString("cEP"));
					toUnidade.setCidade(rs.getString("cidade"));
					toUnidade.setUf(rs.getString("uF"));
					toUnidade.setPais(rs.getString("pais"));
					toUnidade.setNumeroEndereco(rs.getString("numeroEndereco"));
					toUnidade.setRepresentante(rs.getString("representante"));
					toUnidade.setTel1(rs.getString("tel1"));
					toUnidade.setTel2(rs.getString("tel2"));
					toUnidade.setCel(rs.getString("cel"));
					toUnidade.setFlagAtivo(rs.getString("flagAtivo"));
					toUnidade.setDataCadastro(rs.getDate("dataCadastro"));	
					toUnidade.setLatitude(rs.getDouble("latitude"));	
					toUnidade.setLongitude(rs.getDouble("longitude"));	
					
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}
		return toUnidade;
	}
	
	public ArrayList<TOUnidade> listarUnidades(){
		TOUnidade toUnidade;
		ArrayList<TOUnidade> lista = new ArrayList<>();
		String sqlSelect = "SELECT * FROM tcc.unidade where flagAtivo = 1 order by codUnidade desc";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = FabricaConexao.getConexao(); 
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			try (ResultSet rs = stm.executeQuery();) {
				while(rs.next()) {
					toUnidade = new TOUnidade();
					
					toUnidade.setCodUnidade(rs.getInt("codUnidade"));
					toUnidade.setRazaoSocial(rs.getString("razaoSocial"));
					toUnidade.setNomeFantasia(rs.getString("nomeFantasia"));
					toUnidade.setCnpj(rs.getString("cNPJ"));
					toUnidade.setNomeRede(rs.getString("nomeRede"));
					toUnidade.setEndereco(rs.getString("endereco"));
					toUnidade.setCep(rs.getString("cEP"));
					toUnidade.setCidade(rs.getString("cidade"));
					toUnidade.setUf(rs.getString("uF"));
					toUnidade.setPais(rs.getString("pais"));
					toUnidade.setNumeroEndereco(rs.getString("numeroEndereco"));
					toUnidade.setRepresentante(rs.getString("representante"));
					toUnidade.setTel1(rs.getString("tel1"));
					toUnidade.setTel2(rs.getString("tel2"));
					toUnidade.setCel(rs.getString("cel"));
					toUnidade.setFlagAtivo(rs.getString("flagAtivo"));
					toUnidade.setDataCadastro(rs.getDate("dataCadastro"));					
					toUnidade.setLatitude(rs.getDouble("latitude"));	
					toUnidade.setLongitude(rs.getDouble("longitude"));	
					
					lista.add(toUnidade);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}
		return lista;
	}
	
	public ArrayList<TOUnidade> listarUnidades(String chave){
		TOUnidade toUnidade;
		ArrayList<TOUnidade> lista = new ArrayList<>();
		String sqlSelect = "SELECT * from  tcc.unidade where upper(nomeFantasia) like ? and flagAtivo = 1";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = FabricaConexao.getConexao(); 
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
				stm.setString(1, "%" + chave.toUpperCase() + "%");
			try (ResultSet rs = stm.executeQuery();) {
				while(rs.next()) {
					toUnidade = new TOUnidade();
					
					toUnidade.setCodUnidade(rs.getInt("codUnidade"));
					toUnidade.setRazaoSocial(rs.getString("razaoSocial"));
					toUnidade.setNomeFantasia(rs.getString("nomeFantasia"));
					toUnidade.setCnpj(rs.getString("cNPJ"));
					toUnidade.setNomeRede(rs.getString("nomeRede"));
					toUnidade.setEndereco(rs.getString("endereco"));
					toUnidade.setCep(rs.getString("cEP"));
					toUnidade.setCidade(rs.getString("cidade"));
					toUnidade.setUf(rs.getString("uF"));
					toUnidade.setPais(rs.getString("pais"));
					toUnidade.setNumeroEndereco(rs.getString("numeroEndereco"));
					toUnidade.setRepresentante(rs.getString("representante"));
					toUnidade.setTel1(rs.getString("tel1"));
					toUnidade.setTel2(rs.getString("tel2"));
					toUnidade.setCel(rs.getString("cel"));
					toUnidade.setFlagAtivo(rs.getString("flagAtivo"));
					toUnidade.setDataCadastro(rs.getDate("dataCadastro"));					
					toUnidade.setLatitude(rs.getDouble("latitude"));	
					toUnidade.setLongitude(rs.getDouble("longitude"));	
					
					lista.add(toUnidade);
				}
			} catch (SQLException e) {
				e.printStackTrace(); 
			}
		} catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}
		return lista;
	} 
	
	public ArrayList<TOUnidade> listarUnidadeCod(String codUnidade){
		TOUnidade toUnidade;
		ArrayList<TOUnidade> lista = new ArrayList<>();
		String sqlSelect = "SELECT * from  tcc.unidade where codUnidade = ?";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = FabricaConexao.getConexao(); 
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
				stm.setString(1, codUnidade);
			try (ResultSet rs = stm.executeQuery();) {
				while(rs.next()) {
					toUnidade = new TOUnidade();
					
					toUnidade.setCodUnidade(rs.getInt("codUnidade"));
					toUnidade.setRazaoSocial(rs.getString("razaoSocial"));
					toUnidade.setNomeFantasia(rs.getString("nomeFantasia"));
					toUnidade.setCnpj(rs.getString("cNPJ"));
					toUnidade.setNomeRede(rs.getString("nomeRede"));
					toUnidade.setEndereco(rs.getString("endereco"));
					toUnidade.setCep(rs.getString("cEP"));
					toUnidade.setCidade(rs.getString("cidade"));
					toUnidade.setUf(rs.getString("uF"));
					toUnidade.setPais(rs.getString("pais"));
					toUnidade.setNumeroEndereco(rs.getString("numeroEndereco"));
					toUnidade.setRepresentante(rs.getString("representante"));
					toUnidade.setTel1(rs.getString("tel1"));
					toUnidade.setTel2(rs.getString("tel2"));
					toUnidade.setCel(rs.getString("cel"));
					toUnidade.setFlagAtivo(rs.getString("flagAtivo"));
					toUnidade.setDataCadastro(rs.getDate("dataCadastro"));					
					toUnidade.setLatitude(rs.getDouble("latitude"));	
					toUnidade.setLongitude(rs.getDouble("longitude"));	
					
					lista.add(toUnidade);
				}
			} catch (SQLException e) {
				e.printStackTrace(); 
			}
		} catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}
		return lista;
	} 
	
	
	public ArrayList<TOUnidade> listarUnidadePlano(String chave){
		TOUnidade toUnidade;
		ArrayList<TOUnidade> lista = new ArrayList<>();
		String sqlSelect = "SELECT * FROM Unidade U INNER JOIN AssociativaPlanoUnidade APU ON U.codUnidade = APU.codUnidade INNER JOIN Plano P ON APU.codPlano = P.codPlano INNER JOIN Paciente PC ON P.codPlano = PC.codPlano WHERE PC.codPaciente = ? and U.flagAtivo = 1";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = FabricaConexao.getConexao(); 
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
				stm.setString(1,chave.toUpperCase());
			try (ResultSet rs = stm.executeQuery();) {
				while(rs.next()) {
					toUnidade = new TOUnidade();
					
					toUnidade.setCodUnidade(rs.getInt("codUnidade"));
					toUnidade.setRazaoSocial(rs.getString("razaoSocial"));
					toUnidade.setNomeFantasia(rs.getString("nomeFantasia"));
					toUnidade.setCnpj(rs.getString("cNPJ"));
					toUnidade.setNomeRede(rs.getString("nomeRede"));
					toUnidade.setEndereco(rs.getString("endereco"));
					toUnidade.setCep(rs.getString("cEP"));
					toUnidade.setCidade(rs.getString("cidade"));
					toUnidade.setUf(rs.getString("uF"));
					toUnidade.setPais(rs.getString("pais"));
					toUnidade.setNumeroEndereco(rs.getString("numeroEndereco"));
					toUnidade.setRepresentante(rs.getString("representante"));
					toUnidade.setTel1(rs.getString("tel1"));
					toUnidade.setTel2(rs.getString("tel2"));
					toUnidade.setCel(rs.getString("cel"));
					toUnidade.setFlagAtivo(rs.getString("flagAtivo"));
					toUnidade.setDataCadastro(rs.getDate("dataCadastro"));					
					toUnidade.setLatitude(rs.getDouble("latitude"));	
					toUnidade.setLongitude(rs.getDouble("longitude"));	
					
					lista.add(toUnidade);
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
