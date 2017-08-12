package DAO;

import ConnectionFactory.FabricaConexao;
import TO.TOAgendamento;

import java.sql.Connection; 
import java.sql.PreparedStatement; 
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList; 
import java.util.Date;

public class DAOAgendamento {

	public void cadastrarAgendamento(TOAgendamento toAgendamento){
		String sqlInsert = "INSERT INTO tcc.plano (dataAgendamentoComeco,dataAgendamentoFim, statusAgendamento, flagAtivo, dataCadastro) VALUES (current_timestamp(),current_timestamp(),?,1,current_timestamp())";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = FabricaConexao.getConexao(); 
				PreparedStatement stm = conn.prepareStatement(sqlInsert);) {

			java.util.Date dataUtil = new java.util.Date();
			//SimpleDateFormat inputdate = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

			//String strDate = inputdate.format(dataUtil);
			
			//long longDate = Long.valueOf(strDate);
			
			java.sql.Date dataSql = new java.sql.Date(dataUtil.getTime());
			//java.sql.Date dataSql = new java.sql.Date(longDate);
						
			/*stm.setDate(1,toAgendamento.getDataHoraComeco());*/
			/*stm.setDate(2,toAgendamento.getDataHoraFim());*/
			stm.setString(1,toAgendamento.getStatusAgendamento());
			/*stm.setString(4,toAgendamento.getFlagAtivo());*/
			//stm.setString(4,toAgendamento.getFlagAtivo());
			//stm.setDate(5,dataSql);
			
			stm.execute();
			
			String sqlSelect = "SELECT LAST_INSERT_ID()";
			
			try(PreparedStatement stm1 = conn.prepareStatement(sqlSelect);
					ResultSet rs = stm1.executeQuery();){
					if(rs.next()){
						toAgendamento.setCodAgendamento(rs.getInt(1));
					}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void alterarAgendamento(TOAgendamento toAgendamento){
		String sqlUpdate = "UPDATE tcc.agendamento SET dataAgendamentoComeco = ?, dataAgendamentoFim = ?, statusAgendamento = ?, flagAtivo = ?, dataCadastro = ? WHERE codAgendamento = ?";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = FabricaConexao.getConexao(); 
			PreparedStatement stm = conn.prepareStatement(sqlUpdate);) {
			
			stm.setDate(1,(java.sql.Date) toAgendamento.getDataHoraComeco());
			stm.setDate(2,(java.sql.Date) toAgendamento.getDataHoraFim());
			stm.setString(3,toAgendamento.getStatusAgendamento());
			stm.setInt(4,Integer.parseInt(toAgendamento.getFlagAtivo()));
			stm.setInt(5,toAgendamento.getCodAgendamento());
			
			stm.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void excluirAgendamento(TOAgendamento toAgendamento){
		String sqlDelete = "DELETE FROM tcc.agendamento WHERE codAgendamento = ?";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = FabricaConexao.getConexao(); 
				PreparedStatement stm = conn.prepareStatement(sqlDelete);) {
			
			stm.setInt(1, toAgendamento.getCodAgendamento());
			
			stm.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public TOAgendamento consultarAgendamentoCod(int codAgendamentoBusca){
		TOAgendamento toAgendamento = new TOAgendamento();
		toAgendamento.setCodAgendamento(codAgendamentoBusca);
		String sqlSelect = "SELECT  dataAgendamentoComeco, dataAgendamentoFim, statusAgendamento, flagAtivo, dataCadastro FROM tcc.agendamento where codAgendamento = ?";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = FabricaConexao.getConexao(); 
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			stm.setInt(1, codAgendamentoBusca);
			try (ResultSet rs = stm.executeQuery();) {
				if (rs.next()) {
					
					//toAgendamento.setCodAgendamento(rs.getInt("codAgendamento"));
					toAgendamento.setDataHoraComeco(rs.getDate("dataAgendamentoComeco"));
					toAgendamento.setDataHoraFim(rs.getDate("dataAgendamentoFim")); 
					toAgendamento.setStatusAgendamento(rs.getString("statusAgendamento"));								
					toAgendamento.setFlagAtivo(rs.getString("flagAtivo"));
					toAgendamento.setDataCadastro(rs.getDate("dataCadastro"));
					
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}
		return toAgendamento;
	}
	
	public ArrayList<TOAgendamento> listarAgendamentos(){
		TOAgendamento toAgendamento;
		ArrayList<TOAgendamento> lista = new ArrayList<>();
		String sqlSelect = "SELECT  dataAgendamentoComeco, dataAgendamentoFim, statusAgendamento, flagAtivo, dataCadastro FROM tcc.agendamento order by codAgendamento desc";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = FabricaConexao.getConexao(); 
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			try (ResultSet rs = stm.executeQuery();) {
				while(rs.next()) {
					toAgendamento = new TOAgendamento();
								
					toAgendamento.setCodAgendamento(rs.getInt("codAgendamento"));
					toAgendamento.setDataHoraComeco(rs.getDate("dataAgendamentoComeco"));
					toAgendamento.setDataHoraFim(rs.getDate("dataAgendamentoFim")); 
					toAgendamento.setStatusAgendamento(rs.getString("statusAgendamento"));								
					toAgendamento.setFlagAtivo(rs.getString("flagAtivo"));
					toAgendamento.setDataCadastro(rs.getDate("dataCadastro"));
					
					lista.add(toAgendamento);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (SQLException e1) {
			System.out.print(e1.getStackTrace());
		}
		return lista;
	}
	
	/*
	public ArrayList<TOAgendamento> listarAgendamentos(String chave){
		TOAgendamento toAgendamento;
		ArrayList<TOAgendamento> lista = new ArrayList<>();
		String sqlSelect = "SELECT  dataAgendamentoComeco, dataAgendamentoFim, statusAgendamento, flagAtivo, dataCadastro FROM tcc.agendamento where upper(nomeAgendamento) like '?' order by codAgendamento desc";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = FabricaConexao.getConexao(); 
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
				stm.setString(1, "%" + chave.toUpperCase() + "%");
			try (ResultSet rs = stm.executeQuery();) {
				while(rs.next()) {
					toAgendamento = new TOAgendamento();
					
					toAgendamento.setCodAgendamento(rs.getInt("codAgendamento"));
					toAgendamento.setNomeAgendamento(rs.getString("nomeAgendamento"));
					toAgendamento.setRegistroAns(rs.getString("registroAns")); 
					toAgendamento.setTipoAgendamento(rs.getString("tipoAgendamento"));								
					toAgendamento.setFlagAtivo(rs.getString("flagAtivo"));
					toAgendamento.setDataCadastro(rs.getDate("dataCadastro"));
									
					lista.add(toAgendamento);
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
