package com.jit.boot.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jit.boot.model.Book;

@RestController
@RequestMapping("/books")
public class BookRestController {

	@GetMapping("/all")
	public ResponseEntity<List<Book>> getAllBooks() {
		return ResponseEntity.ok(Arrays.asList(new Book(10, "Core Java", "SAM"), new Book(11, "Adv Java", "RAM"),
				new Book(12, "Spring Boot", "SAM"), new Book(13, "Microservices", "SYED")));
	}

	@GetMapping("/find/{id}")
	public ResponseEntity<Book> getOneBook(@PathVariable Integer id) {
		return ResponseEntity.ok(new Book(id, "Dummy Book", "Dummy Author"));
	}

	@PostMapping("/create")
	public ResponseEntity<String> createNewBook(@RequestBody Book book) {
		return ResponseEntity.ok(book.toString());
	}

	@DeleteMapping("/remove/{id}")
	public ResponseEntity<String> deleteBook(@PathVariable Integer id) {
		return ResponseEntity.ok("Book deleted : " + id);

	}
}
