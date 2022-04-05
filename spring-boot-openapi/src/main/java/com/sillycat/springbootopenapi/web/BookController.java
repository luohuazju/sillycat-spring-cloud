package com.sillycat.springbootopenapi.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.sillycat.springbootopenapi.model.Book;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/books")
@Slf4j
public class BookController {

	@Operation(summary = "Get a book by its id")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "Found the book", content = {
					@Content(mediaType = "application/json", schema = @Schema(implementation = Book.class)) }),
			@ApiResponse(responseCode = "400", description = "Invalid id supplied", content = @Content),
			@ApiResponse(responseCode = "404", description = "Book not found", content = @Content) })
	@GetMapping("/{id}")
	public Book findByID(@PathVariable Long id) {
		log.info("findbyId get path variable id = " + id);
		Book item = new Book();
		item.setId(Long.valueOf(1));
		item.setBookName("Java and Python");
		item.setBookCode("java_python");
		return item;
	}

	@GetMapping("/")
	public List<Book> findBooks() {
		Book item1 = new Book();
		item1.setId(Long.valueOf(1));
		item1.setBookName("Java and Python");
		item1.setBookCode("java_python");

		Book item2 = new Book();
		item2.setId(Long.valueOf(2));
		item2.setBookName("Java and Golang");
		item2.setBookCode("java_golang");

		List<Book> list = new ArrayList<>();
		list.add(item1);
		list.add(item2);
		return list;
	}

	@PutMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public Book updateBook(@PathVariable("id") String id, @RequestBody final Book book) {
		log.info("updatebook get book info = " + book);
		return book;
	}

	@PostMapping("/")
	public Book saveBook(@RequestBody Book book) {
		log.info("saveBook get book info = " + book);
		return book;
	}
}
