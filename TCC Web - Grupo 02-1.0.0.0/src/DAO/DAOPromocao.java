package DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import ConnectionFactory.FabricaConexao;
import TO.TOPromocao;

public class DAOPromocao {
	
	public void cadastrarPromocao(TOPromocao toPromocao){
		String sqlInsert = "INSERT INTO tcc.promocao (valorPromocao,dataInicio,dataTermino,flagAtivo,dataCadastro) VALUES (?,?,?,1,current_timestamp())";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = FabricaConexao.getConexao(); 
				PreparedStatement stm = conn.prepareStatement(sqlInsert);) {

			stm.setDouble(1,toPromocao.getValorPromocao());
			stm.setDate(2,(Date) toPromocao.getDataInicio());
			stm.setDate(3,(Date) toPromocao.getDataTermino());

			stm.execute();
			
			String sqlSelect = "SELECT LAST_INSERT_ID()";
			
			try(PreparedStatement stm1 = conn.prepareStatement(sqlSelect);
					ResultSet rs = stm1.executeQuery();){
					if(rs.next()){
						toPromocao.setCodPromocao(rs.getInt(1));
					}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void alterarPromocao(TOPromocao toPromocao){
		String sqlUpdate = "UPDATE tcc.promocao SET valorPromocao = ?, dataInicio = ?, dataTermino = ?, flagAtivo = ? WHERE codPromocao = ? ";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = FabricaConexao.getConexao(); 
			PreparedStatement stm = conn.prepareStatement(sqlUpdate);) {
			
			stm.setDouble(1,toPromocao.getValorPromocao());
			stm.setDate(2,(Date) toPromocao.getDataInicio());
			stm.setDate(3,(Date) toPromocao.getDataTermino());
			stm.setInt(4,Integer.parseInt(toPromocao.getFlagAtivo()));
			stm.setInt(5,toPromocao.getCodPromocao());
			
			stm.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void excluirPromocao(TOPromocao toPromocao){
		String sqlDelete = "DELETE FROM tcc.promocao WHERE codPromocao =?";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = FabricaConexao.getConexao(); 
				PreparedStatement stm = conn.prepareStatement(sqlDelete);) {
			
			stm.setInt(1, toPromocao.getCodPromocao());
			
			stm.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}		
	}
	
	public TOPromocao consultarPromocaoCod(int codPromocaoBusca){
		TOPromocao toPromocao = new TOPromocao();
		toPromocao.setCodPromocao(codPromocaoBusca);
		String sqlSelect = " select valorPromocao,dataInicio,dataTermino,flagAtivo,dataCadastro from tcc.promocao where codPromocao = ?";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = FabricaConexao.getConexao(); 
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			stm.setInt(1, codPromocaoBusca);
			try (ResultSet rs = stm.executeQuery();) {
				if (rs.next()) {
					
					//toPromocao.setCodPromocao(codPromocaoBusca);
					toPromocao.setValorPromocao(rs.getDouble("valorPromocao"));
					toPromocao.setDataInicio(rs.getDate("dataInicio"));
					toPromocao.setDataTermino(rs.getDate("dataTermino"));
					toPromocao.setFlagAtivo(rs.getString("flagAtivo"));
					toPromocao.setDataCadastro(rs.getDate("dataCadastro"));
					
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}
		return toPromocao;
	}
	
	public ArrayList<TOPromocao> listarPromocoes(){
		TOPromocao toPromocao;
		ArrayList<TOPromocao> lista = new ArrayList<>();
		String sqlSelect = "SELECT * FROM tcc.promocao";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = FabricaConexao.getConexao(); 
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			try (ResultSet rs = stm.executeQuery();) {
				while(rs.next()) {
					toPromocao = new TOPromocao();
					
					toPromocao.setCodPromocao(rs.getInt("codPromocao"));
					toPromocao.setValorPromocao(rs.getDouble("valorPromocao"));
					toPromocao.setDataInicio(rs.getDate("dataInicio"));
					toPromocao.setDataTermino(rs.getDate("dataTermino"));
					toPromocao.setFlagAtivo(rs.getString("flagAtivo"));
					toPromocao.setDataCadastro(rs.getDate("dataCadastro"));
					
					lista.add(toPromocao);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}
		return lista;
	}
	
	/*public ArrayList<TOPromocao> toPromocao(String chave){
		TOPromocao toPromocao;
		ArrayList<TOPromocao> lista = new ArrayList<>();
		String sqlSelect = "SELECT * from tcc.promocao where upper(nomeFantasia) like '?'";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = FabricaConexao.getConexao(); 
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
				stm.setString(1, "%" + chave.toUpperCase() + "%");
			try (ResultSet rs = stm.executeQuery();) {
				while(rs.next()) {
					toPromocao = new TOPromocao();
					
					toPromocao.setCodPromocao(rs.getInt("codPromocao"));
					toPromocao.setValorPromocao(rs.getDouble("valorPromocao"));
					toPromocao.setDataInicio(rs.getDate("dataInicio"));
					toPromocao.setDataTermino(rs.getDate("dataTermino"));
					toPromocao.setFlagAtivo(rs.getString("flagAtivo"));
					toPromocao.setDataCadastro(rs.getDate("dataCadastro"));
					
					lista.add(toPromocao);
				}
			} catch (SQLException e) {
				e.printStackTrace(); 
			}
		} catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}
		return lista;
	}
	*/

}
