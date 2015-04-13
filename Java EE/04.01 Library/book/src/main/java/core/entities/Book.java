package core.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="book")
public class Book{
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	@Column(name = "title")
	private String title;
	@Column(name = "isbn")
	private String isbn;
	
	public Book() {}

	//Getters
	public Long getId() {
		return id;
	}
	
	public String getTitle() {
		return title;
	}
	
	public String getIsbn() {
		return isbn;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String toString(){
		return getId()+"\t"+getTitle()+"\t"+getIsbn();	
	}
}
