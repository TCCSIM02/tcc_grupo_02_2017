package DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import ConnectionFactory.FabricaConexao;
import TO.TOAdministrador;


public class DAOAdministrador {

	/**/
	public void cadastrarAdministrador(TOAdministrador toAdministrador, int codLoginCadastrado){
		String sqlInsert = "INSERT INTO tcc.administrador(numeroEndereco,nomeAdministrador,cPF,dataNascimento,email,estadoCivil,nacionalidade,endereco,cEP,cidade,uF,pais,tel1,tel2,cel,dataCadastro,codLogin) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,current_timestamp(),?)";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = FabricaConexao.getConexao(); 
				PreparedStatement stm = conn.prepareStatement(sqlInsert);) {

			java.util.Date dataUtil = new java.util.Date();
			java.sql.Date dataSql = new java.sql.Date(dataUtil.getTime());

			
			stm.setString(1,toAdministrador.getNumeroEndereco() );
			stm.setString(2,toAdministrador.getNome());
			stm.setString(3,toAdministrador.getCpf());
			stm.setDate(4,(Date) toAdministrador.getDataNascimento() );
			stm.setString(5,toAdministrador.getEmail()) ;
			stm.setString(6,toAdministrador.getEstadoCivil()) ;
			stm.setString(7,toAdministrador.getNacionalidade());
			stm.setString(8,toAdministrador.getEndereco());
			stm.setString(9,toAdministrador.getCep()) ;
			stm.setString(10,toAdministrador.getCidade() );
			stm.setString(11,toAdministrador.getUf()) ;
			stm.setString(12,toAdministrador.getPais() );
			stm.setString(13,toAdministrador.getTel1()); 
			stm.setString(14,toAdministrador.getTel2()); 
			stm.setString(15,toAdministrador.getCel()) ;
			stm.setInt(16,codLoginCadastrado) ;

			stm.execute();
			
			String sqlSelect = "SELECT LAST_INSERT_ID()";
			
			try(PreparedStatement stm1 = conn.prepareStatement(sqlSelect);
					ResultSet rs = stm1.executeQuery();){
					if(rs.next()){
						toAdministrador.setCodAdministrador(rs.getInt(1));
					}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	
	
	public void alterarAdministrador(TOAdministrador toAdministrador){
		String sqlUpdate = "UPDATE tcc.administrador SET numeroEndereco = ?, nomeAdministrador = ?, cPF = ?, dataNascimento = ?, email = ?, estadoCivil = ?, nacionalidade = ?, endereco = ?, cEP = ?, cidade = ?, uF = ?, pais = ?, tel1 = ?, tel2 = ?, cel = ? WHERE codAdministrador = ?";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = FabricaConexao.getConexao(); 
			PreparedStatement stm = conn.prepareStatement(sqlUpdate);) {		
			
			stm.setString(1,toAdministrador.getNumeroEndereco());
			stm.setString(2,toAdministrador.getNome());
			stm.setString(3,toAdministrador.getCpf());
			stm.setDate(4,(Date) toAdministrador.getDataNascimento() );
			stm.setString(5,toAdministrador.getEmail()) ;
			stm.setString(6,toAdministrador.getEstadoCivil()) ;
			stm.setString(7,toAdministrador.getNacionalidade());
			stm.setString(8,toAdministrador.getEndereco());
			stm.setString(9,toAdministrador.getCep()) ;
			stm.setString(10,toAdministrador.getCidade() );
			stm.setString(11,toAdministrador.getUf()) ;
			stm.setString(12,toAdministrador.getPais() );
			stm.setString(13,toAdministrador.getTel1()); 
			stm.setString(14,toAdministrador.getTel2()); 
			stm.setString(15,toAdministrador.getCel());
			stm.setInt(16,toAdministrador.getCodAdministrador());
			
			
			stm.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	public void excluirAdministrador(TOAdministrador toAdministrador){
		String sqlDelete = "DELETE FROM tcc.administrador WHERE codAdministrador = ?";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = FabricaConexao.getConexao(); 
				PreparedStatement stm = conn.prepareStatement(sqlDelete);) {
			
			stm.setInt(1, toAdministrador.getCodAdministrador());
			
			stm.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	public TOAdministrador consultarAdministradorCod(int codAdministradorBusca){
		TOAdministrador toAdministrador = new TOAdministrador();
		toAdministrador.setCodAdministrador(codAdministradorBusca);
		String sqlSelect = "SELECT * FROM tcc.administrador where codAdministrador = ?";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = FabricaConexao.getConexao(); 
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			stm.setInt(1, codAdministradorBusca);
			try (ResultSet rs = stm.executeQuery();) {
				if (rs.next()) {
					
					toAdministrador.setNumeroEndereco(rs.getString("numeroEndereco"));
					toAdministrador.setDataCadastro(rs.getDate("dataCadastro"));
					toAdministrador.setNome(rs.getString("nomeAdministrador"));
					toAdministrador.setCpf(rs.getString("cPF"));
					toAdministrador.setDataNascimento(rs.getDate("dataNascimento"));
					toAdministrador.setEstadoCivil(rs.getString("estadoCivil"));
					toAdministrador.setNacionalidade(rs.getString("nacionalidade"));
					toAdministrador.setEndereco(rs.getString("endereco"));
					toAdministrador.setCep(rs.getString("cEP"));
					toAdministrador.setCidade(rs.getString("cidade"));
					toAdministrador.setUf(rs.getString("uF"));
					toAdministrador.setPais(rs.getString("pais"));
					toAdministrador.setTel1(rs.getString("tel1"));
					toAdministrador.setTel2(rs.getString("tel2"));
					toAdministrador.setCel(rs.getString("cel"));
					toAdministrador.setFlagAtivo(rs.getString("flagAtivo"));
					toAdministrador.setEmail(rs.getString("email"));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}
		return toAdministrador;
	}
	
	public ArrayList<TOAdministrador> listarAdministradores(){
		TOAdministrador toAdministrador;
		ArrayList<TOAdministrador> lista = new ArrayList<>();
		String sqlSelect = "SELECT * FROM tcc.administrador order by codAdministrador desc";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = FabricaConexao.getConexao(); 
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			try (ResultSet rs = stm.executeQuery();) {
				while(rs.next()) {
					toAdministrador = new TOAdministrador();
								
					toAdministrador.setCodAdministrador(rs.getInt("codAdministrador"));
					toAdministrador.setNumeroEndereco(rs.getString("numeroEndereco"));
					toAdministrador.setDataCadastro(rs.getDate("dataCadastro"));
					toAdministrador.setNome(rs.getString("nomeAdministrador"));
					toAdministrador.setCpf(rs.getString("cPF"));
					toAdministrador.setDataNascimento(rs.getDate("dataNascimento"));
					toAdministrador.setEstadoCivil(rs.getString("estadoCivil"));
					toAdministrador.setNacionalidade(rs.getString("nacionalidade"));
					toAdministrador.setEndereco(rs.getString("endereco"));
					toAdministrador.setCep(rs.getString("cEP"));
					toAdministrador.setCidade(rs.getString("cidade"));
					toAdministrador.setUf(rs.getString("uF"));
					toAdministrador.setPais(rs.getString("pais"));
					toAdministrador.setTel1(rs.getString("tel1"));
					toAdministrador.setTel2(rs.getString("tel2"));
					toAdministrador.setCel(rs.getString("cel"));
					toAdministrador.setFlagAtivo(rs.getString("flagAtivo"));
					toAdministrador.setEmail(rs.getString("email"));
									
					lista.add(toAdministrador);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}
		return lista;
	}
	
	
	public ArrayList<TOAdministrador> listarAdministrador(String chave){
		TOAdministrador toAdministrador;
		ArrayList<TOAdministrador> lista = new ArrayList<>();
							
		String sqlSelect = "SELECT * from  tcc.administrador where upper(nomeAdministrador) like '?'";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = FabricaConexao.getConexao(); 
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
				stm.setString(1, "%" + chave.toUpperCase() + "%");
			try (ResultSet rs = stm.executeQuery();) {
				while(rs.next()) {
					toAdministrador = new TOAdministrador();
					
					toAdministrador.setCodAdministrador(rs.getInt("codAdministrador"));
					toAdministrador.setNumeroEndereco(rs.getString("numeroEndereco"));
					toAdministrador.setDataCadastro(rs.getDate("dataCadastro"));
					toAdministrador.setNome(rs.getString("nomeAdministrador"));
					toAdministrador.setCpf(rs.getString("cPF"));
					toAdministrador.setDataNascimento(rs.getDate("dataNascimento"));
					toAdministrador.setEstadoCivil(rs.getString("estadoCivil"));
					toAdministrador.setNacionalidade(rs.getString("nacionalidade"));
					toAdministrador.setEndereco(rs.getString("endereco"));
					toAdministrador.setCep(rs.getString("cEP"));
					toAdministrador.setCidade(rs.getString("cidade"));
					toAdministrador.setUf(rs.getString("uF"));
					toAdministrador.setPais(rs.getString("pais"));
					toAdministrador.setTel1(rs.getString("tel1"));
					toAdministrador.setTel2(rs.getString("tel2"));
					toAdministrador.setCel(rs.getString("cel"));
					toAdministrador.setFlagAtivo(rs.getString("flagAtivo"));
					toAdministrador.setEmail(rs.getString("email"));
									
					lista.add(toAdministrador);
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
