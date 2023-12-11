package com.api.book.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.api.book.entities.Book;

@Service
public class BookService {

	private static List<Book> list = new ArrayList<>();

	static {
		list.add(new Book(1, "java reference Book", "Pc Roy"));
		list.add(new Book(2, "Copmlete Knowldege of Java", "Anto"));
		list.add(new Book(3, "Lets Learn Spring Boot", "xyz"));
		list.add(new Book(4, "Easy To Learn Hibernate", "Gream Smith"));
	}

	// Get All Books
	public List<Book> getAllBooks() {
		return list;
	}

	// findBookById
	public Book getBookById(int id) {
		Book book = null;
		book = list.stream().filter(e -> e.getId() == id).findFirst().get();
		return book;
	}

	// Adding the book
	public Book addBook(Book b) {
		list.add(b);
		return b;
	}

	// delete Book
	public void deleteBook(int bid) {

		list = list.stream().filter(book -> book.getId() != bid).collect(Collectors.toList());

	}

	public void updateBook(Book book, int bookId) {
		list.stream().map(b->{
			if(b.getId()==bookId)
			{
				b.setTitle(book.getTitle());
				b.setAuthor(b.getAuthor());
			}
				return b;
		}).collect(Collectors.toList());

	}
}
