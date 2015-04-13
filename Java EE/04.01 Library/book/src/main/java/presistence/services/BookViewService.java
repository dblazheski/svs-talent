package presistence.services;

import java.util.List;

import presistence.Screen;
import core.application.RecordNotFoundException;
import core.controller.BookController;
import core.controller.BookView;
import core.entities.Book;

public class BookViewService implements BookView{
	private Screen screen;
	private BookController bookController;
	
	public BookViewService() {
		this.screen = new Screen();
	}
	
	public void setBookController(BookController bookController) {
		this.bookController = bookController;
	}
	
	public void getAllBooks(){
		bookController.listAllBooks();
	}
	
	public void listAllBooks(List<Book> books) {
		for(Book book : books){
			screen.print(book.toString());
		}
	}
	
	public void addNewBook(Book book){
		bookController.insertNewBook(book);
	}
	
	public void removeBook(Long id){
		bookController.removeBook(id);
	}
	
	public void createBook(String isbn, String title){
		Book book = new Book();
		//book.setId(0L);
		book.setTitle(title);
		book.setIsbn(isbn);
		addNewBook(book);
	}

	public Book getBookById(Long id) throws RecordNotFoundException {
		return bookController.getBookById(id);
	}

	public void updateBook(Book book) {
		bookController.updateBook(book);
	}
	
}
