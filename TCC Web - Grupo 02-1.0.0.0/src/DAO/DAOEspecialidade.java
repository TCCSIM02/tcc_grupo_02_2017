package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import ConnectionFactory.FabricaConexao;
import TO.TOEspecialidade;
public class DAOEspecialidade {
	
	public void cadastrarEspecialidade(TOEspecialidade toEspecialidade){
		String sqlInsert = "INSERT INTO tcc.especialidade (descricao,flagAtivo)VALUES (?,?)";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = FabricaConexao.getConexao(); 
			PreparedStatement stm = conn.prepareStatement(sqlInsert);) {

			stm.setString(1,toEspecialidade.getDescricao());
			stm.setString(2,toEspecialidade.getFlagAtivo());			

			stm.execute();
			
			String sqlSelect = "SELECT LAST_INSERT_ID()";
			
			try(PreparedStatement stm1 = conn.prepareStatement(sqlSelect);
					ResultSet rs = stm1.executeQuery();){
					if(rs.next()){
						toEspecialidade.setCodEspecialidade(rs.getInt(1));
					}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public TOEspecialidade consultarEspecialidadeCod(int codEspecialidadeBusca){
		TOEspecialidade toEspecialidade = new TOEspecialidade();
		toEspecialidade.setCodEspecialidade(codEspecialidadeBusca);
		String sqlSelect = " select * from tcc.especialidade where codEspecialidade = ?";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = FabricaConexao.getConexao(); 
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			stm.setInt(1, codEspecialidadeBusca);
			try (ResultSet rs = stm.executeQuery();) {
				if (rs.next()) {
					

					//toEspecialidade.setCodEspecialidade(codEspecialidadeBusca);
					toEspecialidade.setFlagAtivo(rs.getString("flagAtivo"));
					toEspecialidade.setDescricao(rs.getString("descricao"));
					
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}
		return toEspecialidade;
	}
	
	public ArrayList<TOEspecialidade> listarEspecialidades(){
		TOEspecialidade toEspecialidade;
		ArrayList<TOEspecialidade> lista = new ArrayList<>();
		String sqlSelect = "select * from tcc.especialidade ";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = FabricaConexao.getConexao(); 
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			try (ResultSet rs = stm.executeQuery();) {
				while(rs.next()) {
					toEspecialidade = new TOEspecialidade();
					
					toEspecialidade.setCodEspecialidade(rs.getInt("codEspecialidade"));
					toEspecialidade.setFlagAtivo(rs.getString("flagAtivo"));
					toEspecialidade.setDescricao(rs.getString("descricao"));
					
					lista.add(toEspecialidade);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}
		return lista;
	}
	
	public ArrayList<TOEspecialidade> listarEspecialidades(String chave){
		TOEspecialidade toEspecialidade;
		ArrayList<TOEspecialidade> lista = new ArrayList<>();
		String sqlSelect = "select * from tcc.especialidade where upper(descricao) like '?'";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = FabricaConexao.getConexao(); 
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
				stm.setString(1, "%" + chave.toUpperCase() + "%");
			try (ResultSet rs = stm.executeQuery();) {
				while(rs.next()) {
					toEspecialidade = new TOEspecialidade();
					
					toEspecialidade.setCodEspecialidade(rs.getInt("codEspecialidade"));
					toEspecialidade.setFlagAtivo(rs.getString("flagAtivo"));
					toEspecialidade.setDescricao(rs.getString("descricao"));
					
					lista.add(toEspecialidade);
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