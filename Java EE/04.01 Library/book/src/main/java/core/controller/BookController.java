package core.controller;

import java.util.List;

import core.application.RecordNotFoundException;
import core.entities.Book;

public interface BookController {
	public List<Book> listAllBooks();
	public void insertNewBook(Book book);
	public void removeBook(Long id);
	public void updateBook(Book book);
	public Book getBookById(Long id) throws RecordNotFoundException;

}
