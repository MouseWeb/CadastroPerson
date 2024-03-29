package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**	
 * Respons�vel por fazer a conex�o com o banco de dados
 * @author Douglas
 *
 */
public class SingleConnection {
	
	private static String banco = "jdbc:postgresql://localhost:5432/CadastroPerson?autoReconnect=true";
	private static String password = "admin";
	private static String user = "postgres";
	private static Connection connection = null;
	
	static{
		conectar();
	}
	
	public SingleConnection(){
		conectar();
	}
	
	private static void conectar(){
		try {
			
			if (connection == null) {
				Class.forName("org.postgresql.Driver");
				connection = DriverManager.getConnection(banco, user, password);
				connection.setAutoCommit(false);
				
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("Erro ao conectar com o banco de dados");
		}
	}
	
	public static Connection getConnection() {
		return connection;
	}
	
}
