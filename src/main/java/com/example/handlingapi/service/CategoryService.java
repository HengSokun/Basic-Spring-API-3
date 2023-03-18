package com.example.handlingapi.service;

import com.example.handlingapi.model.Category;
import com.example.handlingapi.model.dto.CategoryDTO;
import com.example.handlingapi.model.request.CategoryRequest;

import java.util.List;

public interface CategoryService {

    List<Category> getAllCategories();

    Category getCategoryById(Integer categoryId);
//    CategoryDTO getCategoryById(Integer categoryId);

    Category addNewCategory(CategoryRequest categoryRequest);

    boolean deleteCategoryById(Integer categoryId);

    Integer updateCategoryById(Integer categoryId, CategoryRequest categoryRequest);
}
