package com.mycompany.bookstore.controller;

import com.mycompany.bookstore.model.Book;
import com.mycompany.bookstore.repository.BookRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {
    private final BookRepository repository;

    BookController(BookRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/books")
    List<Book> all() {
        return repository.findAll();
    }

    @PostMapping("/books")
    Book newBook(@RequestBody Book newBook) {
        return repository.save(newBook);
    }

    @GetMapping("/books/{id}")
    Book one(@PathVariable String id) {

        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Book not found"));
    }

    @PutMapping("/books/{id}")
    Book updateBook(@RequestBody Book newBook, @PathVariable String id) {

        return repository.findById(id)
                .map(book -> {
                    book.setTitle(newBook.getTitle());
                    book.setAuthor(newBook.getAuthor());
                    return repository.save(book);
                })
                .orElseGet(() -> {
                    return repository.save(newBook);
                });
    }

    @DeleteMapping("/books/{id}")
    void deleteBook(@PathVariable String id) {
        repository.deleteById(id);
    }
}
