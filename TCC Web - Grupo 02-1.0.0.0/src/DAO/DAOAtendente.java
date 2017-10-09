package DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import ConnectionFactory.FabricaConexao;
import TO.TOAtendente;


public class DAOAtendente {
	
	/**/
	public void cadastrarAtendente(TOAtendente toAtendente, int codLoginCadastrado){
		String sqlInsert = "INSERT INTO tcc.atendente(numeroEndereco,nomeAtendente,cPF,dataNascimento,email,estadoCivil,nacionalidade,endereco,cEP,cidade,uF,pais,tel1,tel2,cel,dataCadastro,codLogin) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,current_timestamp(),?)";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = FabricaConexao.getConexao(); 
				PreparedStatement stm = conn.prepareStatement(sqlInsert);) {

			java.util.Date dataUtil = new java.util.Date();

			java.sql.Date dataSql = new java.sql.Date(dataUtil.getTime());
			
			stm.setString(1,toAtendente.getNumeroEndereco() );
			stm.setString(2,toAtendente.getNome());
			stm.setString(3,toAtendente.getCpf());
			stm.setDate(4,(Date) toAtendente.getDataNascimento() );
			stm.setString(5,toAtendente.getEmail()) ;
			stm.setString(6,toAtendente.getEstadoCivil()) ;
			stm.setString(7,toAtendente.getNacionalidade());
			stm.setString(8,toAtendente.getEndereco());
			stm.setString(9,toAtendente.getCep()) ;
			stm.setString(10,toAtendente.getCidade() );
			stm.setString(11,toAtendente.getUf()) ;
			stm.setString(12,toAtendente.getPais() );
			stm.setString(13,toAtendente.getTel1()); 
			stm.setString(14,toAtendente.getTel2()); 
			stm.setString(15,toAtendente.getCel()) ;
			stm.setInt(16,codLoginCadastrado) ;

			stm.execute();
			
			String sqlSelect = "SELECT LAST_INSERT_ID()";
			
			try(PreparedStatement stm1 = conn.prepareStatement(sqlSelect);
					ResultSet rs = stm1.executeQuery();){
					if(rs.next()){
						toAtendente.setCodAtendente(rs.getInt(1));
					}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void alterarAtendente(TOAtendente toAtendente){
		String sqlUpdate = "UPDATE tcc.atendente SET numeroEndereco = ?, nomeAtendente = ?, cPF = ?, dataNascimento = ?, email = ?, estadoCivil = ?, nacionalidade = ?, endereco = ?, cEP = ?, cidade = ?, uF = ?, pais = ?, tel1 = ?, tel2 = ?, cel = ? WHERE codAtendente = ?";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = FabricaConexao.getConexao(); 
			PreparedStatement stm = conn.prepareStatement(sqlUpdate);) {		
			
			stm.setString(1,toAtendente.getNumeroEndereco() );
			stm.setString(2,toAtendente.getNome());
			stm.setString(3,toAtendente.getCpf());
			stm.setDate(4,(Date) toAtendente.getDataNascimento() );
			stm.setString(5,toAtendente.getEmail()) ;
			stm.setString(6,toAtendente.getEstadoCivil()) ;
			stm.setString(7,toAtendente.getNacionalidade());
			stm.setString(8,toAtendente.getEndereco());
			stm.setString(9,toAtendente.getCep()) ;
			stm.setString(10,toAtendente.getCidade() );
			stm.setString(11,toAtendente.getUf()) ;
			stm.setString(12,toAtendente.getPais() );
			stm.setString(13,toAtendente.getTel1()); 
			stm.setString(14,toAtendente.getTel2()); 
			stm.setString(15,toAtendente.getCel());
			stm.setInt(16,toAtendente.getCodAtendente());
			
			
			stm.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void excluirAtendente(TOAtendente toAtendente){
		String sqlDelete = "DELETE FROM tcc.atendente WHERE codAtendente = ?";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = FabricaConexao.getConexao(); 
				PreparedStatement stm = conn.prepareStatement(sqlDelete);) {
			
			stm.setInt(1, toAtendente.getCodAtendente());
			
			stm.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public TOAtendente consultarAtendenteCod(int codAtendenteBusca){
		TOAtendente toAtendente = new TOAtendente();
		toAtendente.setCodAtendente(codAtendenteBusca);
		String sqlSelect = "SELECT * FROM tcc.atendente where codAtendente = ?";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = FabricaConexao.getConexao(); 
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			stm.setInt(1, codAtendenteBusca);
			try (ResultSet rs = stm.executeQuery();) {
				if (rs.next()) {
					
					toAtendente.setNumeroEndereco(rs.getString("numeroEndereco"));
					toAtendente.setDataCadastro(rs.getDate("dataCadastro"));
					toAtendente.setNome(rs.getString("nomeAtendente"));
					toAtendente.setCpf(rs.getString("cPF"));
					toAtendente.setDataNascimento(rs.getDate("dataNascimento"));
					toAtendente.setEstadoCivil(rs.getString("estadoCivil"));
					toAtendente.setNacionalidade(rs.getString("nacionalidade"));
					toAtendente.setEndereco(rs.getString("endereco"));
					toAtendente.setCep(rs.getString("cEP"));
					toAtendente.setCidade(rs.getString("cidade"));
					toAtendente.setUf(rs.getString("uF"));
					toAtendente.setPais(rs.getString("pais"));
					toAtendente.setTel1(rs.getString("tel1"));
					toAtendente.setTel2(rs.getString("tel2"));
					toAtendente.setCel(rs.getString("cel"));
					toAtendente.setFlagAtivo(rs.getString("flagAtivo"));
					toAtendente.setEmail(rs.getString("email"));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}
		return toAtendente;
	}
	
	public ArrayList<TOAtendente> listarAtendentes(){
		TOAtendente toAtendente;
		ArrayList<TOAtendente> lista = new ArrayList<>();
		String sqlSelect = "SELECT * FROM tcc.atendente order by codAtendente desc";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = FabricaConexao.getConexao(); 
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			try (ResultSet rs = stm.executeQuery();) {
				while(rs.next()) {
					toAtendente = new TOAtendente();
								
					toAtendente.setCodAtendente(rs.getInt("codAtendente"));
					toAtendente.setNumeroEndereco(rs.getString("numeroEndereco"));
					toAtendente.setDataCadastro(rs.getDate("dataCadastro"));
					toAtendente.setNome(rs.getString("nomeAtendente"));
					toAtendente.setCpf(rs.getString("cPF"));
					toAtendente.setDataNascimento(rs.getDate("dataNascimento"));
					toAtendente.setEstadoCivil(rs.getString("estadoCivil"));
					toAtendente.setNacionalidade(rs.getString("nacionalidade"));
					toAtendente.setEndereco(rs.getString("endereco"));
					toAtendente.setCep(rs.getString("cEP"));
					toAtendente.setCidade(rs.getString("cidade"));
					toAtendente.setUf(rs.getString("uF"));
					toAtendente.setPais(rs.getString("pais"));
					toAtendente.setTel1(rs.getString("tel1"));
					toAtendente.setTel2(rs.getString("tel2"));
					toAtendente.setCel(rs.getString("cel"));
					toAtendente.setFlagAtivo(rs.getString("flagAtivo"));
					toAtendente.setEmail(rs.getString("email"));
									
					lista.add(toAtendente);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}
		return lista;
	}
	
	
	public ArrayList<TOAtendente> listarAtendente(String chave){
		TOAtendente toAtendente;
		ArrayList<TOAtendente> lista = new ArrayList<>();
							
		String sqlSelect = "SELECT * from  tcc.atendente where upper(nomeAtendente) like ?";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = FabricaConexao.getConexao(); 
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
				stm.setString(1, "%" + chave.toUpperCase() + "%");
			try (ResultSet rs = stm.executeQuery();) {
				while(rs.next()) {
					toAtendente = new TOAtendente();
					
					toAtendente.setCodAtendente(rs.getInt("codAtendente"));
					toAtendente.setNumeroEndereco(rs.getString("numeroEndereco"));
					toAtendente.setDataCadastro(rs.getDate("dataCadastro"));
					toAtendente.setNome(rs.getString("nomeAtendente"));
					toAtendente.setCpf(rs.getString("cPF"));
					toAtendente.setDataNascimento(rs.getDate("dataNascimento"));
					toAtendente.setEstadoCivil(rs.getString("estadoCivil"));
					toAtendente.setNacionalidade(rs.getString("nacionalidade"));
					toAtendente.setEndereco(rs.getString("endereco"));
					toAtendente.setCep(rs.getString("cEP"));
					toAtendente.setCidade(rs.getString("cidade"));
					toAtendente.setUf(rs.getString("uF"));
					toAtendente.setPais(rs.getString("pais"));
					toAtendente.setTel1(rs.getString("tel1"));
					toAtendente.setTel2(rs.getString("tel2"));
					toAtendente.setCel(rs.getString("cel"));
					toAtendente.setFlagAtivo(rs.getString("flagAtivo"));
					toAtendente.setEmail(rs.getString("email"));
									
					lista.add(toAtendente);
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
