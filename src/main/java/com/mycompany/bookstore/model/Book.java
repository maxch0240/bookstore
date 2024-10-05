package com.mycompany.bookstore.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.mycompany.bookstore.enums.BookGenreEnum;
import com.mycompany.bookstore.enums.BookLanguageEnum;
import com.mycompany.bookstore.enums.BookTagEnum;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;
import org.hibernate.annotations.UuidGenerator;

import java.util.LinkedList;

@Entity
@Table(name = "books")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_DEFAULT)
public class Book {
    @Id
    @UuidGenerator
    @Column(name = "id", unique = true, updatable = false)
    private String id;

    @Column(name = "title")
    private String title;

    @Column(name = "author")
    private String author;

    @Column(name = "number_of_pages")
    private int numberOfPages;

    @Column(name = "year_released")
    private int yearReleased;

    @Column(name = "description")
    private String description;

//    private BookLanguageEnum language;
//    private LinkedList<BookTagEnum> bookTags;
//    private LinkedList<BookGenreEnum> bookGenres;
}
