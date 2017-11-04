package DAO;

import ConnectionFactory.FabricaConexao;
import TO.TOAgendamento;

import java.sql.Connection; 
import java.sql.PreparedStatement; 
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList; 
import java.util.Date;

public class DAOAgendamento {
	
	public void cadastrarAgendamento(TOAgendamento toAgendamento){
		String sqlInsert = "INSERT INTO tcc.agendamento (codPaciente, codMedico, codUnidade, codEspecialidade, dataAgendamentoComeco, dataAgendamentoFim, dataCadastro) VALUES (?, ?, ?, ?, ?, ?, current_timestamp())";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = FabricaConexao.getConexao(); 
				PreparedStatement stm = conn.prepareStatement(sqlInsert);) {

			System.out.println(toAgendamento.getDataHoraComeco());
			java.sql.Timestamp dataHoraInicio = new java.sql.Timestamp(toAgendamento.getDataHoraComeco().getTime());
			java.sql.Timestamp dataHoraFinal = new java.sql.Timestamp(toAgendamento.getDataHoraFim().getTime());
			
						
			stm.setInt(1,toAgendamento.getCodPaciente());
			stm.setInt(2,toAgendamento.getCodMedico());
			stm.setInt(3,toAgendamento.getCodUnidade());
			stm.setInt(4,toAgendamento.getCodEspecialidade());
			stm.setTimestamp(5, dataHoraInicio);
			stm.setTimestamp(6, dataHoraFinal);
			

			
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
		String sqlUpdate = "UPDATE tcc.agendamento SET dataAgendamentoComeco = ?, dataAgendamentoFim = ?, statusAgendamento = ?, dataCadastro = ? WHERE codAgendamento = ?";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = FabricaConexao.getConexao(); 
			PreparedStatement stm = conn.prepareStatement(sqlUpdate);) {
			
			stm.setDate(1,(java.sql.Date) toAgendamento.getDataHoraComeco());
			stm.setDate(2,(java.sql.Date) toAgendamento.getDataHoraFim());
			//stm.setInt(3,Integer.parseInt(toAgendamento.getFlagAtivo()));
			stm.setInt(3,toAgendamento.getCodAgendamento());
			
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
		String sqlSelect = "SELECT  dataAgendamentoComeco, dataAgendamentoFim, statusAgendamento, dataCadastro FROM tcc.agendamento where codAgendamento = ? and flagAtivo = 1";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = FabricaConexao.getConexao(); 
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			stm.setInt(1, codAgendamentoBusca);
			try (ResultSet rs = stm.executeQuery();) {
				if (rs.next()) {
					
					//toAgendamento.setCodAgendamento(rs.getInt("codAgendamento"));
					toAgendamento.setDataHoraComeco(rs.getDate("dataAgendamentoComeco"));
					toAgendamento.setDataHoraFim(rs.getDate("dataAgendamentoFim")); 							
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
	
	public ArrayList<TOAgendamento> listarAgendamentos() throws ParseException{
		TOAgendamento toAgendamento;
		ArrayList<TOAgendamento> lista = new ArrayList<>();
		String sqlSelect = "SELECT codAgendamento, CAST(dataAgendamentoComeco AS char) as dataAgendamentoComeco, CAST(dataAgendamentoFim AS char) as dataAgendamentoFim, statusAgendamento, dataCadastro FROM tcc.agendamento where flagAtivo = 1 order by codAgendamento desc";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = FabricaConexao.getConexao(); 
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			try (ResultSet rs = stm.executeQuery();) {
				while(rs.next()) {
					toAgendamento = new TOAgendamento();
					
					DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
					
					toAgendamento.setCodAgendamento(rs.getInt("codAgendamento"));
					toAgendamento.setDataHoraComeco(format.parse(rs.getString("dataAgendamentoComeco")));
					toAgendamento.setDataHoraFim(format.parse(rs.getString("dataAgendamentoFim"))); 						
					toAgendamento.setDataCadastro(rs.getDate("dataCadastro"));
					
					format.format(format.parse(rs.getString("dataAgendamentoComeco")));
					
					//System.out.println("chegada: " + rs.getString("dataAgendamentoComeco") + " / " + format.parse(rs.getString("dataAgendamentoComeco")) + " / " + format.format(format.parse(rs.getString("dataAgendamentoComeco"))));
					//System.out.println("sa�da: " + rs.getString("dataAgendamentoFim") + " / " + format.format(rs.getDate("dataAgendamentoFim")));
					
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
	
	
	public ArrayList<TOAgendamento> listarAgendamentosMedico(int chave) throws ParseException{
		
		//System.out.println(chave);
		
		TOAgendamento toAgendamento;
		ArrayList<TOAgendamento> lista = new ArrayList<>();
		String sqlSelect = "SELECT * FROM tcc.agendamento a inner join paciente p on a.codPaciente = p.codPaciente where p.flagAtivo = 1 and a.codMedico = ? and a.flagAtivo = 1; ";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = FabricaConexao.getConexao(); 
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
				stm.setInt(1, chave);
			try (ResultSet rs = stm.executeQuery();) {
				while(rs.next()) {
					toAgendamento = new TOAgendamento();
					
					//DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
					
					toAgendamento.setCodAgendamento(rs.getInt("codAgendamento"));
					toAgendamento.setCodPaciente(rs.getInt("codPaciente"));
					toAgendamento.setCodMedico(rs.getInt("codMedico"));
					toAgendamento.setCodUnidade(rs.getInt("codUnidade"));
					toAgendamento.setCodAtendente(rs.getInt("codAtendente"));					
					toAgendamento.setDataHoraComeco(rs.getDate("dataAgendamentoComeco"));
					toAgendamento.setDataHoraFim(rs.getDate("dataAgendamentoFim")); 					
					toAgendamento.setDataCadastro(rs.getDate("dataCadastro"));
					
					//System.out.println("acima o parametro, abaixo o codagendamento");
					
					//System.out.println(toAgendamento.getCodAgendamento());
					
					//System.out.println("testeee");
					
					
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

}
