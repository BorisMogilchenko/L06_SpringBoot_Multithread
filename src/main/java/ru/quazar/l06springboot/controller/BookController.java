package ru.quazar.l06springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.quazar.l06springboot.model.Book;
import ru.quazar.l06springboot.service.BookService;

import java.math.BigDecimal;
import java.util.List;

@RestController
//@RequestMapping("/api")
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping("/books")
    List<Book> getBooks() {
        return bookService.getBooks();
    }

    @GetMapping("/books/{id}")
    Book getBook(@PathVariable Long id) {
        return bookService.getBook(id);
    }

    @PostMapping("/books")
    Book createBook(@RequestBody Book book) {
        return bookService.createBook(book);
    }

    @PutMapping("books/{id}")
    Book updateBook(@RequestBody Book book, @PathVariable Long id) {
        return bookService.updateBook(id, book);
    }

    @PatchMapping("books/{id}/{isbn}")
    Book changeBookCode(@RequestBody Book book, @PathVariable Long id, String isbn) {
        return bookService.changeBookIsbn(id, isbn, book);
    }

    @PatchMapping("books/{id}/{price}")
    Book changeBookPrice(@RequestBody Book book, @PathVariable Long id, BigDecimal price) {
        return bookService.changeBookPrice(id, price, book);
    }

    @DeleteMapping("/books")
    void deleteAllBooks() {
        bookService.deleteAllBooks();
    }

    @DeleteMapping("/books/{id}")
    void deleteBook(@PathVariable Long id) {
        bookService.deleteBook(id);
    }
}
