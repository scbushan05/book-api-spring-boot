package com.bushansirgur.bookapi.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bushansirgur.bookapi.exception.BookNotFoundException;
import com.bushansirgur.bookapi.model.Book;
import com.bushansirgur.bookapi.repository.BookRepository;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class BookController {
	
	@Autowired
	BookRepository bookRepository;
	
	@GetMapping("/book")
	public List<Book> getAllBooks() {
	    return bookRepository.findAll();
	}
	
	@PostMapping("/book")
	public Book createBook(@Valid @RequestBody Book book) {
	    return bookRepository.save(book);
	}
	
	@GetMapping("/book/{id}")
	public Book getBookById(@PathVariable(value = "id") Long bookId) {
	    return bookRepository.findById(bookId).orElseThrow(() -> new BookNotFoundException("Book", "id", bookId));
	}
	
	@PutMapping("/book/{id}")
	public Book updateBook(@PathVariable(value = "id") Long bookId,
	                                        @Valid @RequestBody Book bookDetails) {

	    bookRepository.findById(bookId).orElseThrow(() -> new BookNotFoundException("Book", "id", bookId));
	    
	    bookDetails.setId(bookId);
	    Book updateBook = bookRepository.save(bookDetails);
	    return updateBook;
	}
	
	@DeleteMapping("/book/{id}")
	public ResponseEntity<?> deleteBook(@PathVariable(value = "id") Long bookId) {
	    Book book = bookRepository.findById(bookId).orElseThrow(() -> new BookNotFoundException("Book", "id", bookId));

	    bookRepository.delete(book);
	    return ResponseEntity.ok().build();
	}
	
	

}
