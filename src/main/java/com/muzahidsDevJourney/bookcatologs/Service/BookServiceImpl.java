package com.muzahidsDevJourney.bookcatologs.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.muzahidsDevJourney.bookcatologs.entity.Book;
import com.muzahidsDevJourney.bookcatologs.repository.BookRepository;
@Service

public class BookServiceImpl implements BookService {
	
	private final BookRepository bookrepo;
	
	@Autowired
	public BookServiceImpl(BookRepository bookrepo) {
		super();
		this.bookrepo = bookrepo;
	}

	@Override
	public Book createBook(Book book) {
		
				
		return bookrepo.save(book);
	}

	@Override
	public List<Book> getAllBooks() {
		
		return (List<Book>)bookrepo.findAll();
	}

	@Override
	public Optional<Book> getBookById(Long id) {
		
		return bookrepo.findById(id);
	}

	@Override
	public Book updateBook(Book updatedBook) {
		// check if the book with provided id exists in the database
		Long bookId=updatedBook.getId();
		Optional<Book>existingbookOptional =bookrepo.findById(bookId);
		if(existingbookOptional.isPresent()) {
			Book existingBook = existingbookOptional.get();
	// Update the fields of the existing book with the fields from the
			//updatedBook
			existingBook.setTitle(updatedBook.getTitle());
			existingBook.setAuthor(updatedBook.getAuthor());
            existingBook.setGenre(updatedBook.getGenre());
            existingBook.setIsbn(updatedBook.getIsbn());
            
            //or
         // Use the builder pattern to update the fields of the existing book
//            existingBook = Book.builder()
//                //.id(existingBook.getId())
//                .title(updatedBook.getTitle())
//                .author(updatedBook.getAuthor())
//                .genre(updatedBook.getGenre())
//                .isbn(updatedBook.getIsbn())
//                .build();

             
            return bookrepo.save(existingBook);

		}else {
// If the book with the provided id does not exist,
	//you may choose to throw an exception or handle it accordingly.
		throw new RuntimeException("Book with id " + bookId + " not found.");
		}
		
		
						
	}

	@Override
	public void deleteBook(Long id) {
		bookrepo.deleteById(id);
		
	}



	
}
