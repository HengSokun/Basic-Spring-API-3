package com.example.handlingapi.controller;

import com.example.handlingapi.model.Book;
import com.example.handlingapi.model.Category;
import com.example.handlingapi.model.request.CategoryRequest;
import com.example.handlingapi.model.response.BookResponse;
import com.example.handlingapi.model.response.CategoryResponse;
import com.example.handlingapi.model.response.PayloadResponse;
import com.example.handlingapi.service.BookService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/v1/books")
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/all-books")
    @Operation(summary = "Get all book from list")
    public ResponseEntity<PayloadResponse<List<Book>>> getAllBook(){
        PayloadResponse<List<Book>> payloadResponse = PayloadResponse.<List<Book>>builder()
                .timestamp(LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss")))
                .status(200)
                .message("Successfully fetched all books")
                .payload(bookService.getAllBook())
                .build();
        return new ResponseEntity<>(payloadResponse, HttpStatus.OK);
    }

    @GetMapping("/{book_id}")
    @Operation(summary = "Get book by ID")
    public ResponseEntity<PayloadResponse<List<Book>>> getAllBook(@PathVariable("book_id") Integer book_id){
        PayloadResponse<List<Book>> payloadResponse = PayloadResponse.<List<Book>>builder()
                .timestamp(LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss")))
                .status(200)
                .message("Successfully fetched all books")
                .payload(bookService.getBookById(book_id))
                .build();
        return new ResponseEntity<>(payloadResponse, HttpStatus.OK);
    }

    @PostMapping("/category")
    @Operation(summary = "Add new category to list")
    public ResponseEntity<CategoryResponse<Category>> addNewCategory(@RequestBody CategoryRequest bookRequest) {
        String date = simpleDateFormat.format(new Date());
        CategoryResponse<Category> categoryResponse = CategoryResponse.<Category>builder()
                .timestamp(date)
                .status(200)
                .message("Successfully added category to list")
                .payload(bookService.addNewBook(bookRequest))
                .build();
        return new ResponseEntity<>(categoryResponse, HttpStatus.OK);
    }

    //    Delete category by ID
    @DeleteMapping("/{categoryId}")
    @Operation(summary = "Delete category by ID")
    public ResponseEntity<?> deleteCategoryById(@PathVariable("categoryId") Integer categoryId) {
        String date = simpleDateFormat.format(new Date());
        bookService.deleteBookById(categoryId);
        CategoryResponse<Category> categoryResponse = CategoryResponse.<Category>builder()
                .timestamp(date)
                .status(200)
                .message("Successfully deleted category")
                .build();
        return new ResponseEntity<>(categoryResponse, HttpStatus.OK);
    }

    //    Update category by ID
    @PutMapping("/{book_id}")
    @Operation(summary = "Update book by ID")
    public ResponseEntity<CategoryResponse<Category>> updateCategoryById(@PathVariable("book_id") Integer categoryID, @RequestBody CategoryRequest categoryRequest){
        String date = simpleDateFormat.format(new Date());
        Integer categoryUpdateResponse = bookService.updatebookById(categoryID, categoryRequest);
        System.out.println("Hello this is category id : " + categoryUpdateResponse);
        CategoryResponse<Category> categoryResponse = CategoryResponse.<Category>builder()
                .timestamp(date)
                .status(200)
                .message("Successfully update category")
                .payload(bookService.getBookById(categoryID))
                .build();
        return new ResponseEntity<>(categoryResponse, HttpStatus.OK);

}
