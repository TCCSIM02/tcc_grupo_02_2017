/* 	teste juan */
/*	teste 2*/
package ConnectionFactory;

import java.sql.Connection; 
import java.sql.DriverManager; 
import java.sql.SQLException;


	public class FabricaConexao {
		static {
			try {
				Class.forName("com.mysql.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				throw new RuntimeException(e);
			}
		}

		// Obtem conexao com o banco de dados
		// Alterar para O TCC
		public static Connection getConexao() throws SQLException {
			return DriverManager.getConnection("jdbc:mysql://127.0.0.1/TCC?user=alunos&password=alunos");
		}
	}	
