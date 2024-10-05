package com.mycompany.bookstore.service;

import com.mycompany.bookstore.model.Book;
import com.mycompany.bookstore.repository.BookRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@Transactional(rollbackOn = Exception.class)
@RequiredArgsConstructor
public class BookService {
    private final BookRepository bookRepository;

    public Page<Book> getAllBooks(int page, int size) {
        return  bookRepository.findAll(PageRequest.of(page, size, Sort.by("title")));
    }

    public Book getBook(String id) {
        return bookRepository.findById(id).orElseThrow(() -> new RuntimeException("Book not found"));
    }

    public Book createBook(Book book) {
        return bookRepository.save(book);
    }
}
