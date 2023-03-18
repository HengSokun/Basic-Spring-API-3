package com.example.handlingapi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.net.URI;
import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(UserNotFoundHandler.class)
    ProblemDetail handleUserNotFound(UserNotFoundHandler userNotFoundHandler){
        ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(HttpStatus.NOT_FOUND, userNotFoundHandler.getMessage());
        problemDetail.setType(URI.create("localhost:8080/error/not-found"));
        problemDetail.setTitle("Category Not Found");
        problemDetail.setProperty("time", LocalDateTime.now());
        return problemDetail;
    }
    @ExceptionHandler(BlankFieldHandler.class)
    ProblemDetail handBlankField(BlankFieldHandler blankFieldHandler){
        ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(HttpStatus.BAD_REQUEST, blankFieldHandler.getMessage());
        problemDetail.setType(URI.create("localhost:8080/error/bad-request"));
        problemDetail.setTitle("Insert field is null");
        problemDetail.setProperty("time", LocalDateTime.now());
        return problemDetail;
    }

    @ExceptionHandler(AuthorNotFoundHandler.class)
    ProblemDetail handleAuthorNotFound(AuthorNotFoundHandler authorNotFoundHandler){
        ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(HttpStatus.NOT_FOUND, authorNotFoundHandler.getMessage());
        problemDetail.setType(URI.create("localhost:8080/error/not-found"));
        problemDetail.setTitle("Author Not Found");
        problemDetail.setProperty("time", LocalDateTime.now());
        return problemDetail;
    }

    @ExceptionHandler(BookNotFoundHandler.class)
    ProblemDetail handleAuthorNotFound(BookNotFoundHandler bookNotFoundHandler){
        ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(HttpStatus.NOT_FOUND, bookNotFoundHandler.getMessage());
        problemDetail.setType(URI.create("localhost:8080/error/not-found"));
        problemDetail.setTitle("Book Not Found");
        problemDetail.setProperty("time", LocalDateTime.now());
        return problemDetail;
    }
}
