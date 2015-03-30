package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import library.Book;

public class LibraryDatabase {
	
	public static Connection makeConnection() throws SQLException{
		String url= "jdbc:postgresql://localhost:5432/library";
		String username = "postgres";
		String password = "Library1!";
		return DriverManager.getConnection(url, username, password);
	}

	public static void insertBook(String isbn, String title) throws SQLException{
		Connection connection=makeConnection();
		PreparedStatement preparedStatement=connection.prepareStatement("insert into book(isbn,title) values(?,?)");
		preparedStatement.setString(1, isbn);
		preparedStatement.setString(2, title);
		preparedStatement.executeUpdate();
		preparedStatement.close();
		connection.close();
	}
	
	public static void updateBook(String title,String isbn) throws SQLException{
		Connection connection=makeConnection();
		PreparedStatement preparedStatement=connection.prepareStatement("update book set title=(?) where isbn=(?)");
		preparedStatement.setString(1,title);
		preparedStatement.setString(2,isbn);
		preparedStatement.executeUpdate();
		preparedStatement.close();
		connection.close();
	}
	
	public static void removeBook(String isbn) throws SQLException{
		Connection connection=makeConnection();
		PreparedStatement preparedStatement=connection.prepareStatement("delete from book where isbn=(?)");
		preparedStatement.setString(1, isbn);
		preparedStatement.executeUpdate();
		preparedStatement.close();
		connection.close();
	}
	
	public static List<Book> getBooks() throws SQLException{
		List<Book> books = new ArrayList<Book>();
		Connection connection = makeConnection();
		PreparedStatement preparedStatement=connection.prepareStatement("select * from book");
		ResultSet resultSet = preparedStatement.executeQuery();
		readRecordsFromDB(resultSet,books);
		preparedStatement.close();
		connection.close();
		return books;
	}
	
	private static void readRecordsFromDB(ResultSet rs, List<Book> books) throws SQLException{
		while (rs.next()) {
		    Integer id = rs.getInt("id");
		    String isbn = rs.getString("isbn");
		    String title = rs.getString("title");
		    Book temp=new Book(id,isbn,title);
		    books.add(temp);
		}
	}
}
