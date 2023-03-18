package com.example.handlingapi.service.Implements;

import com.example.handlingapi.model.Book;
import com.example.handlingapi.repository.BookRepository;
import com.example.handlingapi.service.BookService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookImp implements BookService {
    private final BookRepository bookRepository;

    public BookImp(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public List<Book> getAllBook() {
        return bookRepository.getAllBook();
    }
}
