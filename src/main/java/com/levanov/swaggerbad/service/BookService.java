package com.levanov.swaggerbad.service;


import com.levanov.swaggerbad.entity.Book;
import com.levanov.swaggerbad.repository.BookRepository;
import com.levanov.swaggerbad.util.CustomResponse;
import com.levanov.swaggerbad.util.CustomStatus;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
@Slf4j
@Data
public class BookService {

    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public CustomResponse<Book> getAll() {
        List<Book> books;
        try {
            log.info("попытка получить все книги");
            books = bookRepository.findAll();
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return new CustomResponse<>(null, CustomStatus.EXCEPTION);
        }
        log.info("все книги получены");
        return new CustomResponse<>(books, CustomStatus.SUCCESS);
    }

    public CustomResponse<Book> getBookByName(String name) {
        Book book;
        try {
            log.info("ПОПЫТКА ПОЛУЧИТЬ КНИГУ ПО ИМЕНИ");
            book = bookRepository.findBookByName(name).orElseThrow();
        } catch (NoSuchElementException e) {
            log.error(e.getMessage(), e);
            return new CustomResponse<>(null, CustomStatus.NOT_FOUND);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return new CustomResponse<>(null, CustomStatus.EXCEPTION);
        }
        log.info("книга с названием {} получена", name);
        return new CustomResponse<>(Stream.of(book).collect(Collectors.toList()), CustomStatus.SUCCESS);
    }
}
