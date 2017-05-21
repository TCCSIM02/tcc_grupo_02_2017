package DAO;

import ConnectionFactory.FabricaConexao;
import TO.TOPlano;




import java.sql.Connection; 
import java.sql.PreparedStatement; 
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList; 
import java.util.Date;

public class DAOPlano {

	public void cadastrarPlano(TOPlano toPlano){
		String sqlInsert = "INSERT INTO tcc.plano (nomePlano,registroAns,tipoPlano,flagAtivo,dataCadastro) VALUES (?,?,?,1,current_timestamp())";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = FabricaConexao.getConexao(); 
				PreparedStatement stm = conn.prepareStatement(sqlInsert);) {

			java.util.Date dataUtil = new java.util.Date();
			//SimpleDateFormat inputdate = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

			//String strDate = inputdate.format(dataUtil);
			
			//long longDate = Long.valueOf(strDate);
			
			java.sql.Date dataSql = new java.sql.Date(dataUtil.getTime());
			//java.sql.Date dataSql = new java.sql.Date(longDate);
						
			stm.setString(1,toPlano.getNomePlano());
			stm.setString(2,toPlano.getRegistroAns());
			stm.setString(3,toPlano.getTipoPlano());
			//stm.setString(4,toPlano.getFlagAtivo());
			//stm.setDate(5,dataSql);
			
			stm.execute();
			
			String sqlSelect = "SELECT LAST_INSERT_ID()";
			
			try(PreparedStatement stm1 = conn.prepareStatement(sqlSelect);
					ResultSet rs = stm1.executeQuery();){
					if(rs.next()){
						toPlano.setCodPlano(rs.getInt(1));
					}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void alterarPlano(TOPlano toPlano){
		String sqlUpdate = "UPDATE tcc.plano SET nomePlano = ?, registroAns = ?, tipoPlano = ?, flagAtivo = ?, WHERE codPlano = ?";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = FabricaConexao.getConexao(); 
			PreparedStatement stm = conn.prepareStatement(sqlUpdate);) {
			
			stm.setString(1,toPlano.getNomePlano());
			stm.setString(2,toPlano.getRegistroAns());
			stm.setString(3,toPlano.getTipoPlano());
			stm.setString(4,toPlano.getFlagAtivo());
			stm.setInt(5,toPlano.getCodPlano());
			
			stm.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void excluirPlano(TOPlano toPlano){
		String sqlDelete = "DELETE FROM tcc.plano WHERE codPlano =?";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = FabricaConexao.getConexao(); 
				PreparedStatement stm = conn.prepareStatement(sqlDelete);) {
			
			stm.setInt(1, toPlano.getCodPlano());
			
			stm.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public TOPlano consultarPlanoCod(int codPlanoBusca){
		TOPlano toPlano = new TOPlano();
		toPlano.setCodPlano(codPlanoBusca);
		String sqlSelect = "SELECT nomePlano, registroAns, tipoPlano, flagAtivo, dataCadastro FROM tcc.plano where codPlano = ?";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = FabricaConexao.getConexao(); 
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			stm.setInt(1, codPlanoBusca);
			try (ResultSet rs = stm.executeQuery();) {
				if (rs.next()) {
					
					//toPlano.setCodPlano(rs.getInt("codPlano"));
					toPlano.setNomePlano(rs.getString("nomePlano"));
					toPlano.setRegistroAns(rs.getString("registroAns")); 
					toPlano.setTipoPlano(rs.getString("tipoPlano"));								
					toPlano.setFlagAtivo(rs.getString("flagAtivo"));
					toPlano.setDataCadastro(rs.getDate("dataCadastro"));
					
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}
		return toPlano;
	}
	
	public ArrayList<TOPlano> listarPlanos(){
		TOPlano toPlano;
		ArrayList<TOPlano> lista = new ArrayList<>();
		String sqlSelect = "SELECT codPlano, nomePlano, registroAns, tipoPlano, flagAtivo, dataCadastro FROM tcc.plano";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = FabricaConexao.getConexao(); 
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			try (ResultSet rs = stm.executeQuery();) {
				while(rs.next()) {
					toPlano = new TOPlano();
								
					toPlano.setCodPlano(rs.getInt("codPlano"));
					toPlano.setNomePlano(rs.getString("nomePlano"));
					toPlano.setRegistroAns(rs.getString("registroAns")); 
					toPlano.setTipoPlano(rs.getString("tipoPlano"));								
					toPlano.setFlagAtivo(rs.getString("flagAtivo"));
					toPlano.setDataCadastro(rs.getDate("dataCadastro"));
									
					lista.add(toPlano);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}
		return lista;
	}
	
	public ArrayList<TOPlano> listarPlanos(String chave){
		TOPlano toPlano;
		ArrayList<TOPlano> lista = new ArrayList<>();
		String sqlSelect = "SELECT codPlano, nomePlano, registroAns, tipoPlano, flagAtivo, dataCadastro FROM tcc.plano where upper(nomePlano) like '?'";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = FabricaConexao.getConexao(); 
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
				stm.setString(1, "%" + chave.toUpperCase() + "%");
			try (ResultSet rs = stm.executeQuery();) {
				while(rs.next()) {
					toPlano = new TOPlano();
					
					toPlano.setCodPlano(rs.getInt("codPlano"));
					toPlano.setNomePlano(rs.getString("nomePlano"));
					toPlano.setRegistroAns(rs.getString("registroAns")); 
					toPlano.setTipoPlano(rs.getString("tipoPlano"));								
					toPlano.setFlagAtivo(rs.getString("flagAtivo"));
					toPlano.setDataCadastro(rs.getDate("dataCadastro"));
									
					lista.add(toPlano);
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
