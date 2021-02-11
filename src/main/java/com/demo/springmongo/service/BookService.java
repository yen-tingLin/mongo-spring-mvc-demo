package com.demo.springmongo.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.demo.springmongo.model.Book;
import com.demo.springmongo.repository.BookRepository;

@Service
@Transactional
public class BookService {
	
	private final BookRepository bookRepository;

	public BookService(BookRepository bookRepository) {
		this.bookRepository = bookRepository;
	}
	
	public void addBook(Book book) {
		bookRepository.insert(book);
	}
	
	public List<Book> getAllBooks() {
		return bookRepository.findAll();
	}

	public Book getBookByTitle(String title) {
		Book bookFromDb = bookRepository.findByTitle(title)
				.orElseThrow(() -> new RuntimeException(
						String.format("Book not found with title '%s'", title)));
		
		return bookFromDb;
	}
	
	public void updateBook(Book book) {
		Book bookFromDb = bookRepository.findById(book.getId())
				.orElseThrow(() -> new RuntimeException(
						String.format("Book not found with id %s", book.getId())));
		
		bookFromDb.setTitle(book.getTitle());
		bookFromDb.setBookCategory(book.getBookCategory());
		bookFromDb.setSellingPrice(book.getSellingPrice());
		
		bookRepository.save(bookFromDb);
	}
	
	public void deleteBookByTitle(String title) {
		Book bookFromDb = bookRepository.findByTitle(title)
				.orElseThrow(() -> new RuntimeException(
						String.format("Book not found with title '%s'", title)));
		
		bookRepository.delete(bookFromDb);
	}

}
