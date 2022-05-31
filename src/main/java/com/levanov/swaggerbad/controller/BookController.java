package com.levanov.swaggerbad.controller;


import com.levanov.swaggerbad.entity.Book;
import com.levanov.swaggerbad.service.BookService;
import com.levanov.swaggerbad.util.CustomResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/books")
    public CustomResponse<Book> getAll() {
        return bookService.getAll();

    }

    @GetMapping("/books/{name}")
    public CustomResponse<Book> getBookByName(@PathVariable("name") String name) {
        return bookService.getBookByName(name);
    }
}
