package com.example.demo.book.repository;

import com.example.demo.book.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IBookRepository extends JpaRepository<Book, Long> {

    //TODO écrire requête
    List<Book> findByTitleOrAuthor(@Param("name") String name);
}
