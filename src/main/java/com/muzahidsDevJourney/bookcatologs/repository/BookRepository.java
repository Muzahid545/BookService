package com.muzahidsDevJourney.bookcatologs.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.muzahidsDevJourney.bookcatologs.entity.Book;
@Repository
public interface BookRepository extends CrudRepository<Book, Long> {
	

}
