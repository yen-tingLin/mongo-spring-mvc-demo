package com.demo.springmongo.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.springmongo.model.Book;
import com.demo.springmongo.service.BookService;

@RestController
@RequestMapping("/book")
public class BookController {
	
	private final BookService bookService;

	public BookController(BookService bookService) {
		this.bookService = bookService;
	}
	
	@PostMapping("/add")
	public ResponseEntity<String> addBook(@RequestBody Book book) {
		bookService.addBook(book);
//		return ResponseEntity.status(HttpStatus.CREATED).build();		
		return new ResponseEntity<String>("added successfully", HttpStatus.OK);
	}
	
	@GetMapping("/getAll")
	public ResponseEntity<List<Book>> getAllBooks() {
		return ResponseEntity.ok(bookService.getAllBooks());
	}
	
	@PutMapping("/update")
	public ResponseEntity<String> updateBook(@RequestBody Book book) {
		bookService.updateBook(book);
//      return ResponseEntity.status(HttpStatus.OK).build();
		return new ResponseEntity<String>("updated successfully", HttpStatus.OK); 
	}
	
	@GetMapping("/get/{title}")
	public ResponseEntity<Book> getBookByTitle(@PathVariable String title) {
		return ResponseEntity.ok(bookService.getBookByTitle(title));
	}
	
	@DeleteMapping("/delete/{title}")
	public ResponseEntity<String> deleteBookByTitle(@PathVariable String title) {
		bookService.deleteBookByTitle(title);
//        return ResponseEntity.noContent().build();
		return new ResponseEntity<String>("deleted successfully", HttpStatus.OK);
	}
	
}
