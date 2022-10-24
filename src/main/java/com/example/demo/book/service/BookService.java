package com.example.demo.book.service;

import com.example.demo.book.entity.Book;
import com.example.demo.book.repository.IBookRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService implements IBookService {
    private final IBookRepository bookRepository;

    public BookService(IBookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public List<Book> findByTitleOrAuthor(String name) {
        return this.bookRepository.findByTitleOrAuthor(name);
    }

    @Override
    public Optional<Book> findById(Long id) {
        return this.bookRepository.findById(id);
    }

    @Override
    public void save(Book book) {
        this.bookRepository.save(book);
    }
}
