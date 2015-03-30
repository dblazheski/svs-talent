package library;

import java.sql.SQLException;
import java.util.List;

import dao.LibraryDatabase;

public class Library {
	
	public static void registerBook(String isbn, String title) throws SQLException{
		LibraryDatabase.insertBook(isbn, title);
	}
	
	public static List<Book> getBooks() throws SQLException{
		return LibraryDatabase.getBooks();
	}

	public static void updateBooks(String title, String isbn) throws SQLException{
		LibraryDatabase.updateBook(title, isbn);
	}
	
	public static void unregisterBook(String isbn) throws SQLException{
		LibraryDatabase.removeBook(isbn);
	}
}
