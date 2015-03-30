package view;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;
import library.Book;
import library.Library;

public class LibraryMenu {
	Scanner scanner=null;
	int option;
	String title;
	String isbn;
	
	public LibraryMenu() {
		this.scanner=new Scanner(System.in);
	}
	
	public void printOptions(){
		System.out.println("1. Register book");
		System.out.println("2. List registered books");
		System.out.println("3. Update book registration");
		System.out.println("4. Unregister book");
	}
	
	public void readBook(){
		this.title=scanner.next();
	}
	
	public void readIsbn(){
		this.isbn=scanner.next();
	}
	
	public void readOption(){
		this.option = scanner.nextInt();
	}
	
	public void registerBook(){
		System.out.println("Enter the book and isbn:");
		readBook();
		readIsbn();
		try {
			Library.registerBook(isbn, title);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void updateBook(){
		System.out.println("Enter book isbn and new title: ");
		readBook();
		readIsbn();
		try {
			Library.updateBooks(title,isbn);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void listBooks(){
		List<Book> books=null;
		try {
			books = Library.getBooks();
			System.out.println("Availible books :" +books.size()+"\n");
			System.out.println("No.\tISBN\t\tTitle");
			for(Book book : books){
				System.out.println(book.getId()+"\t"+book.getIsbn()+"\t"+book.getTitle());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void quitMenu(){
		scanner.close();
	}
	
	
}
