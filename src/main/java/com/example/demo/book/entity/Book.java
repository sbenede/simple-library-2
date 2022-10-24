package com.example.demo.book.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Book {
    public @Id @GeneratedValue Long id;
    public String title;
    public String author;
    public Integer year;
}
