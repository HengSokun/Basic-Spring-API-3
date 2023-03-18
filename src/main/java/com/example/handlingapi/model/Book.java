package com.example.handlingapi.model;

import java.sql.Timestamp;
import java.util.List;

public class Book {
    private Integer book_id;
    private String title;
    private Timestamp published_date;
    private Author author;
    private List<Category> categories;
}
