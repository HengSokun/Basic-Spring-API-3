package com.example.handlingapi.service;

import com.example.handlingapi.model.Author;
import com.example.handlingapi.model.Category;
import com.example.handlingapi.model.request.AuthorRequest;

import java.util.List;

public interface AuthorService {
    List<Author> getAllAuthor();

    Author getAuthorById(Integer authorId);

    Integer updateAuthorById(Integer authorId, AuthorRequest authorRequest);

    Author addNewAuthor(AuthorRequest authorRequest);

    boolean deleteAuthorById(Integer authorId);
}
