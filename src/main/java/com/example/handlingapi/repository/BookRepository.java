package com.example.handlingapi.repository;

import com.example.handlingapi.model.Book;
import com.example.handlingapi.service.BookService;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface BookRepository {

    @Select("SELECT * FROM books")
    @Result(property = "book_id", column = "book_id")
    @Result(property = "title", column = "title")
    @Result(property = "published_date", column = "published_date")
    @Result(property = "author_id", column = "author_id")
    List<Book> getAllBook();

}
