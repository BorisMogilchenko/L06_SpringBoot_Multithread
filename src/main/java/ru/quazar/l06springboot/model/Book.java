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
    private boolean isBusy;
    private String title;
    private String author;
    private BigDecimal price;

    public Book() {};

    public Book(long id, boolean isBusy, String title, String author, BigDecimal price) {
        this.id = id;
        this.isBusy = isBusy;
        this.title = title;
        this.author = author;
        this.price = price;
    }
}
