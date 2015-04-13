package core.controller;

import java.util.List;

import core.application.BookExsistException;
import core.application.BookManagment;
import core.application.RecordNotFoundException;
import core.entities.Book;

public class BookManagmentController implements BookController{
	private BookManagment bookManagment;
	private BookView bookView;
	
	public BookManagmentController(BookManagment bookManagment, BookView bookView) {
		this.bookManagment = bookManagment;
		this.bookView = bookView;
		this.bookView
		.setBookController(this);
	}
	
	public List<Book> listAllBooks(){
		List<Book> books = bookManagment.ListAllBooks();
		bookView.listAllBooks(books);
		return books;
	}
	
	public void insertNewBook(Book book){
		try {
			bookManagment.RegisterBook(book);
		} catch (BookExsistException e) {
			System.out.println("Book exsist !");
		}
	}
	
	public void removeBook(Long id){
		try {
			bookManagment.UnregisterBook(id);
		} catch (RecordNotFoundException e) {
			System.out.println("Book not found !");
		}
	}

	public void updateBook(Book book) {
		bookManagment.updateBookRegistration(book);
	}

	public Book getBookById(Long id) throws RecordNotFoundException{
		Book book = null;
		try {
			book = bookManagment.getBookById(id);
		} catch (RecordNotFoundException e) {
			System.out.println("Book not found !");
		}
		return book;
	}
}
