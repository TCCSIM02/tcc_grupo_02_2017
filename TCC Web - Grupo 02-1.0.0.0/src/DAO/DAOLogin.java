package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import ConnectionFactory.FabricaConexao;
import TO.TOLogin;
import TO.TOPaciente;

public class DAOLogin {

	public int getUltimoCodLogin(TOLogin toLogin){
		
		int ultimoCodLogin = -1;
		
		String sqlSelect = "SELECT codLogin from tcc.login where nomeLogin = '" + toLogin.getNomeLogin() + "'";
			
		try (Connection conn = FabricaConexao.getConexao();) {

			try(PreparedStatement stm1 = conn.prepareStatement(sqlSelect);
					ResultSet rs = stm1.executeQuery();){
								
					if(rs.next()){
						ultimoCodLogin = rs.getInt("codLogin");
					}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return ultimoCodLogin;
	}
	
	public void cadastrarLogin(TOLogin toLogin){
		String sqlInsert = "INSERT INTO tcc.login (codNivel,nomeLogin,senha,dataCadastro) VALUES (?,?,?,current_timestamp())";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = FabricaConexao.getConexao(); 
				PreparedStatement stm = conn.prepareStatement(sqlInsert);) {
		
			stm.setInt(1,toLogin.getCodNivel());
			stm.setString(2,toLogin.getNomeLogin());
			stm.setString(3,toLogin.getSenhaCriptografada());

			
			stm.execute();
			
			String sqlSelect = "SELECT LAST_INSERT_ID()";
			
			try(PreparedStatement stm1 = conn.prepareStatement(sqlSelect);
					ResultSet rs = stm1.executeQuery();){
					if(rs.next()){
						toLogin.setCodLogin(rs.getInt(1));
					}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	public ArrayList<TOLogin> buscarLogin(String usuario, String senha){
		TOLogin toLogin;
		ArrayList<TOLogin> lista = new ArrayList<>();
							
		String sqlSelect = "SELECT * FROM TCC.LOGIN WHERE nomeLogin = ? AND senha = ? and flagAtivo = 1";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = FabricaConexao.getConexao(); 
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
				stm.setString(1,usuario);
				stm.setString(2,senha);
				
			try (ResultSet rs = stm.executeQuery();) {
				while(rs.next()) {
					toLogin = new TOLogin();
					
					toLogin.setNomeLogin(rs.getString("nomeLogin"));
					toLogin.setSenha(rs.getString("senha"));
					toLogin.setCodLogin(rs.getInt("codLogin"));
					toLogin.setCodNivel(rs.getInt("codNivel"));

					
					lista.add(toLogin);
				}
			} catch (SQLException e) {				
				e.printStackTrace(); 
			}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		return lista;
	}
	
	
}
