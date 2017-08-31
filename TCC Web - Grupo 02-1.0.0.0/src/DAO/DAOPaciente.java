package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import ConnectionFactory.FabricaConexao;
import TO.TOPaciente;

public class DAOPaciente {

	public DAOPaciente(){
		
	}
	
	public void cadastrarPaciente(TOPaciente toPaciente){
		String sqlInsert = "INSERT INTO tcc.paciente(codLogin,numConvenio,nomePaciente,cPF,dataNascimento,email,estadoCivil,nacionalidade,endereco,cEP,uF,pais,tel1,tel2,cel,flagAtivo,dataCadastro) VALUES (?,current_timestamp(),?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = FabricaConexao.getConexao(); 
				PreparedStatement stm = conn.prepareStatement(sqlInsert);) {

			java.util.Date dataUtil = new java.util.Date();
			//SimpleDateFormat inputdate = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

			//String strDate = inputdate.format(dataUtil);
			
			//long longDate = Long.valueOf(strDate);
			
			java.sql.Date dataSql = new java.sql.Date(dataUtil.getTime());
			//java.sql.Date dataSql = new java.sql.Date(longDate);
						
			
			stm.setInt(1,toPaciente.getNumeroEndereco() );
			//stm.setDate(2,toPaciente.getDataCadastro() ) ;
			stm.setString(2,toPaciente.getNome());
			stm.setString(3,toPaciente.getCpf());
			stm.setString(4,toPaciente.getDataNascimento() );
			stm.setString(5,toPaciente.getEstadoCivil()) ;
			stm.setString(6,toPaciente.getNacionalidade());
			stm.setString(7,toPaciente.getLogradouro());
			stm.setString(8,toPaciente.getCep()) ;
			stm.setString(9,toPaciente.getCidade() );
			stm.setString(10,toPaciente.getUf()) ;
			stm.setString(11,toPaciente.getPais() );
			stm.setString(12,toPaciente.getTel1()); 
			stm.setString(13,toPaciente.getTel2()); 
			stm.setString(14,toPaciente.getCel()) ;
			stm.setString(15,"1");
			
			/*TOPaciente*/
			stm.setInt(16,toPaciente.getCodPaciente());
			stm.setString(17,toPaciente.getNumConvenio());
			
			//stm.setString(4,toPaciente.getFlagAtivo());
			//stm.setDate(5,dataSql);
			
			stm.execute();
			
			String sqlSelect = "SELECT LAST_INSERT_ID()";
			
			try(PreparedStatement stm1 = conn.prepareStatement(sqlSelect);
					ResultSet rs = stm1.executeQuery();){
					if(rs.next()){
						toPaciente.setCodPaciente(rs.getInt(1));
					}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
