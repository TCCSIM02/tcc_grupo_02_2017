package DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import ConnectionFactory.FabricaConexao;
import TO.TOConsulta;

public class DAOConsulta{
	public void cadastrarConsulta(TOConsulta toConsulta){
		String sqlInsert = "INSERT INTO tcc.consulta ( statusConsulta,diagnostico,dataConsultaEntrada,dataConsultaSaida,valorConsulta)VALUES (?,?,?,?,?)";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = FabricaConexao.getConexao(); 
				PreparedStatement stm = conn.prepareStatement(sqlInsert);) {

			stm.setString(1,toConsulta.getStatusConsulta());
			stm.setString(2,toConsulta.getDiagnostico());			
			stm.setDate(3,(Date) toConsulta.getDataHoraConsultaInicio());
			stm.setDate(4,(Date) toConsulta.getDataHoraConsultaFinal());
			stm.setDouble(5,toConsulta.getValorConsulta());

			stm.execute();
			
			String sqlSelect = "SELECT LAST_INSERT_ID()";
			
			try(PreparedStatement stm1 = conn.prepareStatement(sqlSelect);
					ResultSet rs = stm1.executeQuery();){
					if(rs.next()){
						toConsulta.setCodConsulta(rs.getInt(1));
					}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void alterarConsulta(TOConsulta toConsulta){
		String sqlUpdate = "UPDATE tcc.consulta SET statusConsulta = ?, diagnostico = ?, dataConsultaEntrada = ?, dataConsultaSaida = ?, valorConsulta = ? WHERE codConsulta = ?";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = FabricaConexao.getConexao(); 
			PreparedStatement stm = conn.prepareStatement(sqlUpdate);) {
			
			stm.setString(1,toConsulta.getStatusConsulta());
			stm.setString(2,toConsulta.getDiagnostico());			
			stm.setDate(3,(Date) toConsulta.getDataHoraConsultaInicio());
			stm.setDate(4,(Date) toConsulta.getDataHoraConsultaFinal());
			stm.setInt(5,toConsulta.getCodConsulta());
			
			stm.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void excluirConsulta(TOConsulta toConsulta){
		String sqlDelete = "DELETE FROM tcc.consulta WHERE codConsulta =?";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = FabricaConexao.getConexao(); 
				PreparedStatement stm = conn.prepareStatement(sqlDelete);) {
			
			stm.setInt(1, toConsulta.getCodConsulta());
			
			stm.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}		
	}
	
	public TOConsulta consultarConsultaCod(int codConsultaBusca){
		TOConsulta toConsulta = new TOConsulta();
		toConsulta.setCodConsulta(codConsultaBusca);
		String sqlSelect = " select * from tcc.consulta where codConsulta = ?";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = FabricaConexao.getConexao(); 
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			stm.setInt(1, codConsultaBusca);
			try (ResultSet rs = stm.executeQuery();) {
				if (rs.next()) {
					

					//toConsulta.setCodConsulta(codConsultaBusca);
					toConsulta.setStatusConsulta(rs.getString("statusConsulta"));
					toConsulta.setDiagnostico(rs.getString("diagnostico"));
					toConsulta.setDataHoraConsultaInicio(rs.getDate("dataConsultaEntrada"));
					toConsulta.setDataHoraConsultaFinal(rs.getDate("dataConsultaSaida"));
					toConsulta.setValorConsulta(rs.getDouble("valorConsulta"));
					
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}
		return toConsulta;
	}
	
	public ArrayList<TOConsulta> listarPromocoes(){
		TOConsulta toConsulta;
		ArrayList<TOConsulta> lista = new ArrayList<>();
		String sqlSelect = "select * from tcc.consulta ";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = FabricaConexao.getConexao(); 
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			try (ResultSet rs = stm.executeQuery();) {
				while(rs.next()) {
					toConsulta = new TOConsulta();
					
					toConsulta.setCodConsulta(rs.getInt("codConsulta"));
					toConsulta.setStatusConsulta(rs.getString("statusConsulta"));
					toConsulta.setDiagnostico(rs.getString("diagnostico"));
					toConsulta.setDataHoraConsultaInicio(rs.getDate("dataConsultaEntrada"));
					toConsulta.setDataHoraConsultaFinal(rs.getDate("dataConsultaSaida"));
					toConsulta.setValorConsulta(rs.getDouble("valorConsulta"));
					
					lista.add(toConsulta);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}
		return lista;
	}
	
	/*public ArrayList<TOConsulta> toConsulta(String chave){
		TOConsulta toConsulta;
		ArrayList<TOConsulta> lista = new ArrayList<>();
		String sqlSelect = "select * from tcc.consulta  where upper(nomeFantasia) like '?'";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = FabricaConexao.getConexao(); 
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
				stm.setString(1, "%" + chave.toUpperCase() + "%");
			try (ResultSet rs = stm.executeQuery();) {
				while(rs.next()) {
					toConsulta = new TOConsulta();
					
					toConsulta.setCodConsulta(rs.getInt("codConsulta"));
					toConsulta.setValorConsulta(rs.getDouble("valorConsulta"));
					toConsulta.setDataInicio(rs.getDate("dataInicio"));
					toConsulta.setDataTermino(rs.getDate("dataTermino"));
					toConsulta.setFlagAtivo(rs.getString("flagAtivo"));
					toConsulta.setDataCadastro(rs.getDate("dataCadastro"));
					
					lista.add(toConsulta);
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
