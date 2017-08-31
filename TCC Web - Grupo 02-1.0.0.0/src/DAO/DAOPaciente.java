package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import ConnectionFactory.FabricaConexao;
import TO.TOPaciente;
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
			stm.setString(7,toPaciente.getEndereco());
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
	
	public ArrayList<TOPaciente> listarPacientes(){
		TOPaciente toPaciente;
		ArrayList<TOPaciente> lista = new ArrayList<>();
		String sqlSelect = "SELECT * FROM tcc.paciente order by codPaciente desc";
		// usando o try with resources do Java 7, que fecha o que abriu
		try (Connection conn = FabricaConexao.getConexao(); 
				PreparedStatement stm = conn.prepareStatement(sqlSelect);) {
			try (ResultSet rs = stm.executeQuery();) {
				while(rs.next()) {
					toPaciente = new TOPaciente();
								
					toPaciente.setNumeroEndereco(rs.getInt("numeroEndereco"));	
					toPaciente.setDataCadastro(rs.getDate("dataCadastro"));
					toPaciente.setNome(rs.getString("nomePaciente"));	
					toPaciente.setCpf(rs.getString("cPF"))	;
					toPaciente.setDataNascimento(rs.getString("dataNascimento"));
					toPaciente.setEstadoCivil(rs.getString("estadoCivil")	);
					toPaciente.setNacionalidade(rs.getString("nacionalidade"));
					toPaciente.setEndereco(rs.getString("endereco"));	
					toPaciente.setCep(rs.getString("cEP"));	
					toPaciente.setCidade(rs.getString("cidade"));	
					toPaciente.setUf(rs.getString("uF"));	
					toPaciente.setPais(rs.getString("pais")	);
					toPaciente.setTel1(rs.getString("tel1"));
					toPaciente.setTel2(rs.getString("tel2"));
					toPaciente.setCel(rs.getString("cel"));
					toPaciente.setFlagAtivo(rs.getString("flagAtivo"));
					toPaciente.setCodPaciente(rs.getInt("codPaciente"));
					toPaciente.setNumConvenio(rs.getString("numConvenio"));
									
					lista.add(toPaciente);
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
