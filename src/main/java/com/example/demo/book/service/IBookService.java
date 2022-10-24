package com.example.demo.book.service;

import com.example.demo.book.entity.Book;

import java.util.List;
import java.util.Optional;

public interface IBookService {
    List<Book> findByTitleOrAuthor(String name);

    Optional<Book> findById(Long id);

    void save(Book book);
}
