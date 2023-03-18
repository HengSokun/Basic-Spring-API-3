package com.example.handlingapi.exception;

public class AuthorNotFoundHandler extends RuntimeException{
    public AuthorNotFoundHandler(String message){
        super(message);
    }
}
