package com.employee2.Hibernate2;

import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Book {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "bookid")
	int id;
	@Column
	String bookname;
	@Column
	int price;
	@Column
	String author;
	@Column
	String publisher;
	
	public Book() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Book(int id, String bookname, int price, String author, String publisher) {
		super();
		this.id = id;
		this.bookname = bookname;
		this.price = price;
		this.author = author;
		this.publisher = publisher;
	}

	public Book(String bookname, int price, String author, String publisher) {
		super();
		this.bookname = bookname;
		this.price = price;
		this.author = author;
		this.publisher = publisher;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBookname() {
		return bookname;
	}

	public void setBookname(String bookname) {
		this.bookname = bookname;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	@Override
	public String toString() {
		return "Book [id=" + id + ", bookname=" + bookname + ", price=" + price + ", author=" + author + ", publisher="
				+ publisher + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(author, bookname, id, price, publisher);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Book other = (Book) obj;
		return Objects.equals(author, other.author) && Objects.equals(bookname, other.bookname) && id == other.id
				&& price == other.price && Objects.equals(publisher, other.publisher);
	}
	
	
}
