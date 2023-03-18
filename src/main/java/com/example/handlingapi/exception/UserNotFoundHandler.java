package com.example.handlingapi.exception;

public class UserNotFoundHandler extends RuntimeException{
    public UserNotFoundHandler(String message){
        super(message);
    }
}
