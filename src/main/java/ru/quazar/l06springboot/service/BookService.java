package ru.quazar.l06springboot.service;

import ru.quazar.l06springboot.model.Book;
import ru.quazar.l06springboot.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class BookService {

    @Autowired
    private BookRepository repository;

    public List<Book> getBooks() {
        return repository.findAll();
    }

    public Book createBook(Book book) {
        return repository.save(book);
    }

    public Book updateBook(Long id, Book book) {
        Book savedBook = repository.findById(id).get();
        savedBook.setIsbn(book.getIsbn());
        savedBook.setAuthor(book.getAuthor());
        savedBook.setTitle(book.getTitle());
        savedBook.setPrice(book.getPrice());
        return repository.save(savedBook);
    }

    public Book changeBookPrice(Long id, BigDecimal price, Book book) {
        Book savedBook = updateBook(id, book);
        savedBook.setPrice(price);
        return repository.save(savedBook);
    }

    public Book changeBookIsbn(Long id, String isbn, Book book) {
        Book savedBook = updateBook(id, book);
        savedBook.setIsbn(isbn);
        return repository.save(savedBook);
    }

    public Book getBook(Long id) {
        return repository.findById(id).get();
    }

    public void deleteAllBooks() {
        repository.deleteAll();
    }

    public void deleteBook(Long id) {
        repository.deleteById(id);
    }
}
