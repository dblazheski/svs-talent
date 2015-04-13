package core.application.services;

import java.util.List;

import core.entities.Book;

public interface bookDao{
	void insert(Book entity);
	void delete(Book entity);
	void update(Book entity);
	Book findById(Long id);
	Book findByTitle(String title);
	Book findByIsbn(String isbn);
	List<Book> findAll();
}
