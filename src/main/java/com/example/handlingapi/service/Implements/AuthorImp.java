package com.example.handlingapi.service.Implements;

import com.example.handlingapi.exception.AuthorNotFoundHandler;
import com.example.handlingapi.exception.UserNotFoundHandler;
import com.example.handlingapi.model.Author;
import com.example.handlingapi.model.Category;
import com.example.handlingapi.model.request.AuthorRequest;
import com.example.handlingapi.repository.AuthorRepository;
import com.example.handlingapi.service.AuthorService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorImp implements AuthorService {
    private final AuthorRepository authorRepository;

    public AuthorImp(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public List<Author> getAllAuthor() {
        return authorRepository.getAllAuthor();
    }

    @Override
    public Author getAuthorById(Integer authorId) {
        if (authorRepository.getAuthorById(authorId) == null){
            throw new  AuthorNotFoundHandler("Author ID:"+ authorId+ " Not Found");
        } else {
            return authorRepository.getAuthorById(authorId);
        }
    }

    @Override
    public Integer updateAuthorById(Integer authorId, AuthorRequest authorRequest) {
        if (authorRepository.getAuthorById(authorId) == null){
            throw new  AuthorNotFoundHandler("Author ID:"+ authorId+ " Not Found");
        } else {
            return authorRepository.updateAuthorById(authorId, authorRequest);
        }
    }

    @Override
    public Author addNewAuthor(AuthorRequest authorRequest) {
        return authorRepository.addNewAuthor(authorRequest);
    }

    @Override
    public boolean deleteAuthorById(Integer authorId) {
        if(!authorRepository.deleteAuthorById(authorId)){
            throw new AuthorNotFoundHandler("Author ID: "+authorId+" Not Found");
        }
        else {
            return authorRepository.deleteAuthorById(authorId);
        }

    }
}
