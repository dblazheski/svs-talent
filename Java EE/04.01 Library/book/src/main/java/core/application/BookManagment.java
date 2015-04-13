package core.application;
import core.application.services.BookService;
import core.entities.Book;

import java.util.List;

public class BookManagment {

	private BookService BookService;
	
	public BookManagment(BookService bookService) {
		this.BookService=bookService;
	}
	
	public void RegisterBook(Book book) throws BookExsistException {
		Book tempBook = BookService.getBookByIsbn(book.getIsbn());
		if(tempBook != null)
			throw new BookExsistException();
		BookService.addNewBook(book);
	}
	
	public List<Book> ListAllBooks(){
		return BookService.getAllBooks();
	}
	
	public void UnregisterBook(Long id) throws RecordNotFoundException{
		Book book = BookService.getBookById(id);
		if(book == null)
			throw new RecordNotFoundException();
		BookService.removeBook(book);
	}
	
	public void updateBookRegistration(Book book){
		BookService.updateBook(book);
	}
	
	public Book getBookById(Long id) throws RecordNotFoundException{
		Book book = BookService.getBookById(id);
		if(book == null)
			throw new RecordNotFoundException();
		return book;
	}
}
