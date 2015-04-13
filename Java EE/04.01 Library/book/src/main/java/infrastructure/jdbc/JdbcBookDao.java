package infrastructure.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import core.application.services.bookDao;
import core.entities.Book;

public class JdbcBookDao implements bookDao{

	public void insert(Book entity){
		Connection connection;
		try {
			connection = JdbcUtil.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement("Insert Into book(isbn, title) values(?, ?)");
			preparedStatement.setString(1, entity.getTitle());
			preparedStatement.setString(2, entity.getIsbn());
			preparedStatement.executeUpdate();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void delete(Book entity) {
		try{
			Connection connection = JdbcUtil.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement("Delete FROM book WHERE isbn = ?");
			preparedStatement.setString(1, entity.getIsbn());
			preparedStatement.execute();
			connection.close();
		} catch(SQLException e){}
		
	}

	public void update(Book entity){
		try{
			Connection connection = JdbcUtil.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement("Update book set title=? WHERE isbn = ?");
			preparedStatement.setString(1, entity.getTitle());
			preparedStatement.setString(2, entity.getIsbn());
			preparedStatement.execute();
			connection.close();
		} catch(SQLException e){}
		
	}

	public Book findById(Long id) {
		Book book = null;
		try{
			Connection connection = JdbcUtil.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement("select * from book where id = ?");
			preparedStatement.setLong(1, id);
			ResultSet results = preparedStatement.executeQuery();
			book = createBook(results);
		}catch(SQLException  e){}
		return book;
	}

	public Book findByTitle(String title) {
		Book book = null;
		try{
			Connection connection = JdbcUtil.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement("select * from book where title = ?");
			preparedStatement.setString(1, title);
			ResultSet results = preparedStatement.executeQuery();
			book = createBook(results);
		}catch(SQLException e){}
		return book;
	}

	public Book findByIsbn(String isbn) {
		Book book = null;
		try{
			Connection connection = JdbcUtil.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement("select * from book where isbn = ?");
			preparedStatement.setString(1, isbn);
			ResultSet results = preparedStatement.executeQuery();
			book = createBook(results);
		}catch(SQLException  e){}
		return book;
	}

	public List<Book> findAll(){
		List<Book> books = null;
		try{
			Connection connection = JdbcUtil.getConnection();
			Statement statement = connection.createStatement();
			ResultSet results = statement.executeQuery("select * from book");
			createListOfBooks(results,books);
		} catch(SQLException e){}
		return books;
	}
	
	private void createListOfBooks(ResultSet results,List<Book> books) throws SQLException{
		while(results.next()){
			Book book = new Book();
			book.setIsbn(results.getString("isbn"));
			book.setTitle(results.getString("title"));
			books.add(book);
		}
	}
	
	private Book createBook(ResultSet results) throws SQLException{
		Book book = null;
		if(results.next())
		book = new Book();
		book.setIsbn(results.getString("isbn"));
		book.setTitle(results.getString("title"));
		return book;
	}

}
