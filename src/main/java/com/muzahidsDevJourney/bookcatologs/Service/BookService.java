package com.muzahidsDevJourney.bookcatologs.Service;

import java.util.List;
import java.util.Optional;

import com.muzahidsDevJourney.bookcatologs.entity.Book;

public interface BookService {
	
	//create a new book
	public Book createBook(Book book);
		
	//get All books

	List<Book> getAllBooks();
	
	//get Book by Id
	public Optional<Book> getBookById(Long id);
	
	//update an existing book
	public Book updateBook(Book updatedBook);
	
	//delete a existing book
	public void deleteBook(Long id);

}
