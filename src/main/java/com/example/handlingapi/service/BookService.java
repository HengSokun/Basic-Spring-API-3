package com.example.handlingapi.service;

import com.example.handlingapi.model.Book;
import com.example.handlingapi.model.Category;
import com.example.handlingapi.model.request.CategoryRequest;

import java.util.List;

public interface BookService {

    List<Book> getAllBook();

    Integer updatebookById(Integer categoryID, CategoryRequest categoryRequest);

    Category getBookById(Integer categoryID);

    void deleteBookById(Integer categoryId);

    Category addNewBook(CategoryRequest bookRequest);
}
