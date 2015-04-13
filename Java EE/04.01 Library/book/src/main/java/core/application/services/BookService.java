package core.application.services;

import java.util.List;

import core.entities.Book;

public class BookService {

	private bookDao bookDao;
	
	public BookService(bookDao bookDao) {
		this.bookDao=bookDao;
	}
	
	public void addNewBook(Book book){
		bookDao.insert(book);
	}
	
	public void removeBook(Book book){
		bookDao.delete(book);
	}
	
	public void updateBook(Book book){
		bookDao.update(book);
	}
	
	public Book getBookById(Long id){
		return bookDao.findById(id);
	}
	
	public Book getBookByTitle(String title){
		return bookDao.findByTitle(title);
	}
	
	public Book getBookByIsbn(String isbn){
		return bookDao.findByIsbn(isbn);
	}
	public List<Book> getAllBooks(){
		return bookDao.findAll();
	}
}
