package com.jit.boot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jit.boot.consumer.BookRestConsumer;
import com.jit.boot.model.Book;

@RestController
@RequestMapping("/publisher")
public class PublisherRestController {

	@Autowired
	private BookRestConsumer consumer;

	@GetMapping("/view")
	public String viewPublisherBooks() {
		ResponseEntity<List<Book>> resp = consumer.getAllBooks();
		return "FROM PUBLISHER : " + resp.getBody();
	}

	@GetMapping("/getOne")
	public String viewOnePublisherBook() {
		ResponseEntity<Book> resp = consumer.getOneBook(500);
		return "FROM PUBLISHER ONE BOOK=>" + resp.getBody();
	}

	@PostMapping("/save")
	public String createOnePublisherBook(@RequestBody Book book) {
		ResponseEntity<String> resp = consumer.createNewBook(book);
		return "FROM PUBLISHER SAVE BOOK=>" + resp.getBody();
	}

	@DeleteMapping("/del/{id}")
	public String removeOnePublisherBook(@PathVariable Integer id) {
		ResponseEntity<String> resp = consumer.deleteBook(id);
		return "FROM PUBLISHER DELETE BOOK=>" + resp.getBody();
	}
}
