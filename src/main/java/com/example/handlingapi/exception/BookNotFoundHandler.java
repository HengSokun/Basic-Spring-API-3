package com.example.handlingapi.exception;

public class BookNotFoundHandler extends RuntimeException{
    public BookNotFoundHandler(String message) {
        super(message);
    }
}
