package com.example.handlingapi.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

public class BlankFieldHandler extends RuntimeException{
    public BlankFieldHandler(String message) {
        super(message);
    }
}
