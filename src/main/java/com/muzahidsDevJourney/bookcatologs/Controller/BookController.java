package com.muzahidsDevJourney.bookcatologs.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.muzahidsDevJourney.bookcatologs.Service.BookService;
import com.muzahidsDevJourney.bookcatologs.entity.Book;

@RestController
@RequestMapping("/book")
public class BookController {
    @Autowired
    BookService bookservice;

    @GetMapping("/all")
    public List<Book> getAllBooks() {
        return bookservice.getAllBooks();
    }
    
    @PostMapping("/create")
    public Book createBook(@RequestBody Book book) {
    	return bookservice.createBook(book);
    }
    @GetMapping("/{id}")
    public Optional<Book> getbyId(@PathVariable Long id) {
    	return bookservice.getBookById(id);
    }
    @PutMapping("/{id}")
    public Book updateBook(@PathVariable ("id")Long id, @RequestBody Book updatedBook) {
        // Make sure the id in the path matches the id in the request body
    	if(!id.equals(updatedBook.getId())) {
    		throw new IllegalArgumentException("Id in path does not match the id in the request body.");
    	}
    	

    	
    	return bookservice.updateBook(updatedBook);
    }
    @DeleteMapping("/{id}")
    public void DeleteBook(@PathVariable Long id) {
    	bookservice.deleteBook(id);
    }
}
