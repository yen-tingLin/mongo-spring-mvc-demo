package com.demo.springmongo.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.demo.springmongo.model.Book;


public interface BookRepository extends MongoRepository<Book, String> {
	@Query("{'title': ?0}")
	Optional<Book> findByTitle(String title);
	@Query("{'title': ?0}")
	void deleteByTitle(String title);
}
