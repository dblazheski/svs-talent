package library;

public class Book {
	private int id;
	private String isbn;
	private String title;
	
	public Book(int id, String isbn, String title) {
		this.id=id;
		this.isbn=isbn;
		this.title=title;
	}
	
	public int getId() {
		return id;
	}
	
	public String getIsbn() {
		return isbn;
	}
	
	public String getTitle() {
		return title;
	}
}
