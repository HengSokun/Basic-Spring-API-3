package com.example.handlingapi.controller;

import com.example.handlingapi.model.Author;
import com.example.handlingapi.model.request.AuthorRequest;
import com.example.handlingapi.model.response.AuthorResponse;
import com.example.handlingapi.service.AuthorService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/v1/author")
public class AuthorController {

    String pattern = "dd-M-yyyy hh:mm:ss";
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
    private final AuthorService authorService;

    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

//    Get all author from list
    @GetMapping("/all")
    @Operation(summary = "Get all authors from list")
    public ResponseEntity<AuthorResponse<List<Author>>> getAllAuthor(){
        String date = simpleDateFormat.format(new Date());
        AuthorResponse<List<Author>> authorResponse = AuthorResponse.<List<Author>>builder()
                .timestamp(date)
                .status(200)
                .message("Successfully fetched authors")
                .payload(authorService.getAllAuthor())
                .build();
        return new ResponseEntity<>(authorResponse, HttpStatus.OK);
    }

//    Get author by ID
    @GetMapping("/{author_id}")
    @Operation(summary = "Get author by ID")
    public ResponseEntity<AuthorResponse<Author>> getAuthorById(@PathVariable("author_id") Integer author_id){
        String date = simpleDateFormat.format(new Date());
        AuthorResponse<Author> authorResponse = AuthorResponse.<Author>builder()
                .timestamp(date)
                .status(200)
                .message("Successfully fetched author")
                .payload(authorService.getAuthorById(author_id))
                .build();
        return new ResponseEntity<>(authorResponse, HttpStatus.OK);
    }

    @PutMapping("/{author_id}")
    @Operation(summary = "Update author by ID")
    public ResponseEntity<AuthorResponse<Author>> updateAuthorById (@PathVariable("author_id") Integer author_id, @RequestBody AuthorRequest authorRequest){
        String date = simpleDateFormat.format(new Date());
        Integer authorUpdateResponse =  authorService.updateAuthorById(author_id, authorRequest);
        System.out.println("Hello this is author id : " + authorUpdateResponse);
        AuthorResponse<Author> authorAuthorResponse = AuthorResponse.<Author>builder()
                .timestamp(date)
                .status(200)
                .message("Successfully updated author")
                .payload(authorService.getAuthorById(author_id))
                .build();
        return  new ResponseEntity<>(authorAuthorResponse, HttpStatus.OK);
    }

//    Add new author to list
    @PostMapping("/add-author")
    @Operation(summary = "Add new author to list")
    public ResponseEntity<AuthorResponse<Author>> addNewAuthor(@RequestBody AuthorRequest authorRequest){
        String date = simpleDateFormat.format(new Date());
        AuthorResponse<Author> authorAuthorResponse = AuthorResponse.<Author>builder()
                .timestamp(date)
                .status(200)
                .message("Successfully added author")
                .payload(authorService.addNewAuthor(authorRequest))
                .build();
        return new ResponseEntity<>(authorAuthorResponse, HttpStatus.OK);
    }

    @DeleteMapping("/{author_id}")
    @Operation(summary = "Delete author by ID")
    public ResponseEntity<AuthorResponse<Author>> deleteAuthorById(@PathVariable("author_id") Integer author_id){
        String date = simpleDateFormat.format(new Date());
        authorService.deleteAuthorById(author_id);
        AuthorResponse<Author> authorAuthorResponse = AuthorResponse.<Author>builder()
                .timestamp(date)
                .status(200)
                .message("Successfully deleted author")
                .build();
        return new ResponseEntity<>(authorAuthorResponse, HttpStatus.OK);
    }
}
