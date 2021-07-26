package ru.quazar.l06springboot.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.math.BigDecimal;

@Data
@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String isbn;
    private String title;
    private String author;
    private BigDecimal price;
    private boolean isBusy;

    public Book() {};

    public Book(long id, String isbn, String title, String author, BigDecimal price, boolean isBusy) {
        this.id = id;
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.price = price;
        this.isBusy = isBusy;
    }
}
