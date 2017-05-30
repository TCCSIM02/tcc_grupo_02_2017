package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import ConnectionFactory.FabricaConexao;
import TO.TOExame;

public class DAOExame {
	
	public void cadastrarExame(TOExame toExame){
		String sqlInsert = "INSERT INTO tcc.exame (descricao, resultadoExame, valorExame) VALUES (?,?,?)";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = FabricaConexao.getConexao(); 
				PreparedStatement stm = conn.prepareStatement(sqlInsert);) {		

			stm.setString(1,toExame.getDescricao());
			stm.setString(2,toExame.getResultadoExame());
			stm.setDouble(3,toExame.getValorExame());
		
			stm.execute();
			
			String sqlSelect = "SELECT LAST_INSERT_ID()";
			
			try(PreparedStatement stm1 = conn.prepareStatement(sqlSelect);
					ResultSet rs = stm1.executeQuery();){
					if(rs.next()){
						toExame.setCodExame(rs.getInt(1));
					}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void alterarExame(TOExame toExame){
		String sqlUpdate = "UPDATE tcc.exame SET descricao = ?, resultadoExame = ?, valorExame = ? WHERE codExame = ?";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = FabricaConexao.getConexao(); 
			PreparedStatement stm = conn.prepareStatement(sqlUpdate);) {
				
			stm.setString(1,toExame.getDescricao());
			stm.setString(2,toExame.getResultadoExame());
			stm.setDouble(3,toExame.getValorExame());
			stm.setInt(4,toExame.getCodExame());
			
			stm.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void excluirExame(TOExame toExame){
		String sqlDelete = "DELETE FROM tcc.exame WHERE codExame = ?";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = FabricaConexao.getConexao(); 
				PreparedStatement stm = conn.prepareStatement(sqlDelete);) {
			
			stm.setInt(1, toExame.getCodExame());
			
			stm.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public TOExame consultarExameCod(int codExameBusca){
		TOExame toExame = new TOExame();
		toExame.setCodExame(codExameBusca);
		String sqlSelect = "SELECT descricao, resultadoExame, valorExame FROM tcc.exame where codExame = ?";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = FabricaConexao.getConexao(); 
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			stm.setInt(1, codExameBusca);
			try (ResultSet rs = stm.executeQuery();) {
				if (rs.next()) {
					
					//toExame.setCodExame(rs.getInt("codExame"));
					toExame.setDescricao(rs.getString("descricao"));
					toExame.setResultadoExame(rs.getString("resultadoExame")); 
					toExame.setValorExame(rs.getDouble("valorExame"));
					
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}
		return toExame;
	}
	
	
	public ArrayList<TOExame> listarExames(){
		TOExame toExame;
		ArrayList<TOExame> lista = new ArrayList<>();
		String sqlSelect = "SELECT codExame, descricao, resultadoExame, valorExame FROM tcc.exame order by codExame desc";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = FabricaConexao.getConexao(); 
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			try (ResultSet rs = stm.executeQuery();) {
				while(rs.next()) {
					toExame = new TOExame();
								
					toExame.setCodExame(rs.getInt("codExame"));
					toExame.setDescricao(rs.getString("descricao"));
					toExame.setResultadoExame(rs.getString("resultadoExame")); 
					toExame.setValorExame(rs.getDouble("valorExame"));
									
					lista.add(toExame);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}
		return lista;
	}
	
	
	public ArrayList<TOExame> listarExames(String chave){
		TOExame toExame;
		ArrayList<TOExame> lista = new ArrayList<>();
		String sqlSelect = "SELECT codExame, descricao, resultadoExame, valorExame FROM tcc.exame where upper(descricao) like '?' order by codExame desc";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = FabricaConexao.getConexao(); 
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
				stm.setString(1, "%" + chave.toUpperCase() + "%");
			try (ResultSet rs = stm.executeQuery();) {
				while(rs.next()) {
					toExame = new TOExame();
					
					toExame.setCodExame(rs.getInt("codExame"));
					toExame.setDescricao(rs.getString("descricao"));
					toExame.setResultadoExame(rs.getString("resultadoExame")); 
					toExame.setValorExame(rs.getDouble("valorExame"));
									
					lista.add(toExame);
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