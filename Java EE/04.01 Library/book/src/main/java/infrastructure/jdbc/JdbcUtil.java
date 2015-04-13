package infrastructure.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcUtil {
	
	private JdbcUtil(){
	}
	
	public static Connection getConnection() throws SQLException{
		Connection connection = null;
		final String url = "jdbc:postgresql://localhost:5432/book";
		final String username = "postgres";
		final String password = "Library1!";
		connection = DriverManager.getConnection(url, username, password);
		return connection;
	}
}
