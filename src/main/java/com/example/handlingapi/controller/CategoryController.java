package com.example.handlingapi.controller;

import com.example.handlingapi.model.Category;
import com.example.handlingapi.model.dto.CategoryDTO;
import com.example.handlingapi.model.request.CategoryRequest;
import com.example.handlingapi.model.response.CategoryResponse;
import com.example.handlingapi.service.CategoryService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/v1/categories")
public class CategoryController {

    String pattern = "dd-M-yyyy hh:mm:ss";
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);


    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    //    Get all category from list
    @GetMapping("/all")
    @Operation(summary = "Get all categories from list")
    public ResponseEntity<CategoryResponse<List<Category>>> getAllCategories() {
        String date = simpleDateFormat.format(new Date());
        CategoryResponse<List<Category>> categoryResponse = CategoryResponse.<List<Category>>builder()
                .timestamp(date)
                .message("Successfully fetched categories")
                .status(200)
                .payload(categoryService.getAllCategories())
                .build();
        return new ResponseEntity<>(categoryResponse, HttpStatus.OK);
    }

    //    Get category by ID
    @GetMapping("/{category_id}")
    @Operation(summary = "Get category by ID")
    public ResponseEntity<?> getCategoryById(@PathVariable("category_id") Integer category_id) {
        String date = simpleDateFormat.format(new Date());
//        CategoryDTO categoryDTO = categoryService.getCategoryById(category_id);
        CategoryResponse<Category> categoryResponse = CategoryResponse.<Category>builder()
                .timestamp(date)
                .status(200)
                .message("Successfully fetched category by ID")
                .payload(categoryService.getCategoryById(category_id))
                .build();
        return new ResponseEntity<>(categoryResponse, HttpStatus.OK);
    }

    //    Add new category to list
    @PostMapping("/category")
    @Operation(summary = "Add new category to list")
    public ResponseEntity<CategoryResponse<Category>> addNewCategory(@RequestBody CategoryRequest categoryRequest) {
        String date = simpleDateFormat.format(new Date());
        CategoryResponse<Category> categoryResponse = CategoryResponse.<Category>builder()
                .timestamp(date)
                .status(200)
                .message("Successfully added category to list")
                .payload(categoryService.addNewCategory(categoryRequest))
                .build();
        return new ResponseEntity<>(categoryResponse, HttpStatus.OK);
    }

    //    Delete category by ID
    @DeleteMapping("/{categoryId}")
    @Operation(summary = "Delete category by ID")
    public ResponseEntity<?> deleteCategoryById(@PathVariable("categoryId") Integer categoryId) {
        String date = simpleDateFormat.format(new Date());
        categoryService.deleteCategoryById(categoryId);
        CategoryResponse<Category> categoryResponse = CategoryResponse.<Category>builder()
                .timestamp(date)
                .status(200)
                .message("Successfully deleted category")
                .build();
        return new ResponseEntity<>(categoryResponse, HttpStatus.OK);
    }

    //    Update category by ID
    @PutMapping("/{category_id}")
    @Operation(summary = "Update category by ID")
    public ResponseEntity<CategoryResponse<Category>> updateCategoryById(@PathVariable("category_id") Integer categoryID, @RequestBody CategoryRequest categoryRequest){
        String date = simpleDateFormat.format(new Date());
        Integer categoryUpdateResponse = categoryService.updateCategoryById(categoryID, categoryRequest);
        System.out.println("Hello this is category id : " + categoryUpdateResponse);
        CategoryResponse<Category> categoryResponse = CategoryResponse.<Category>builder()
                .timestamp(date)
                .status(200)
                .message("Successfully update category")
                .payload(categoryService.getCategoryById(categoryID))
                .build();
        return new ResponseEntity<>(categoryResponse, HttpStatus.OK);
    }


}