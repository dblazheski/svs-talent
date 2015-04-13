package core.controller;

import java.util.List;

import core.application.RecordNotFoundException;
import core.entities.Book;

public interface BookView {
	public void setBookController(BookController bookController);
	public void listAllBooks(List<Book> books);
	public Book getBookById(Long id) throws RecordNotFoundException;
	public void updateBook(Book book);

}
