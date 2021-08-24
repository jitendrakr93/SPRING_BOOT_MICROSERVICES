package com.jit.boot.consumer;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.jit.boot.model.Book;

@FeignClient("BOOK-SERVICE")
public interface BookRestConsumer {

	@GetMapping("/books/all")
	public ResponseEntity<List<Book>> getAllBooks();

	@GetMapping("/books/find/{id}")
	public ResponseEntity<Book> getOneBook(@PathVariable Integer id);

	@PostMapping("/books/create")
	public ResponseEntity<String> createNewBook(@RequestBody Book book);

	@DeleteMapping("/books/remove/{id}")
	public ResponseEntity<String> deleteBook(@PathVariable Integer id);
}
