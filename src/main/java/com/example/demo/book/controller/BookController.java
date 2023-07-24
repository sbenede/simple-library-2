package com.example.demo.book.controller;

import com.example.demo.book.dto.BookDto;
import com.example.demo.book.entity.Book;
import com.example.demo.book.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/library")
public class BookController {

    private IBookService bs;

    /**
     * Create a book
     *
     * @param bookDto DTO corresponding to the book
     */
    @PostMapping
    public void createBook(BookDto bookDto) {
        Book book = new Book();
        book.author = bookDto.author;
        book.title = bookDto.title;
        book.year = bookDto.year;

        this.bs.save(book);
    }

    /**
     * Get a book by his ID
     *
     * @param id book ID
     * @return a book
     */
    @GetMapping(value = "/books/{id}")
    public BookDto getBookById(@PathVariable Long id) {
        Optional<Book> optional = bs.findById(id);

        if (optional.isPresent()) {
            Book book = optional.get();

            BookDto dto = new BookDto();
            dto.title = book.title;
            dto.author = book.author;
            dto.year = book.year;

            return dto;
        }

        return null;
    }

    /**
     * Get books by title or author's name. Books can be found by fulltext search.
     *
     * @param name title or author
     * @return list of books corresponding to the searched text
     */
    @GetMapping(value = "/books")
    public List<BookDto> getBooks(@PathVariable String name) {
        List<Book> bookList = bs.findByTitleOrAuthor(name);
        List<BookDto> books = new ArrayList<>();

        for (int i = 0; i < bookList.size(); i++) {
            Book book = bookList.get(i);

            BookDto dto = new BookDto();
            dto.title = book.title;
            dto.author = book.author;
            dto.year = book.year;

            books.add(dto);
        }

        return books;
    }
}
