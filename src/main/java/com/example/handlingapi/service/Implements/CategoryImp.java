package com.example.handlingapi.service.Implements;

import com.example.handlingapi.exception.BlankFieldHandler;
import com.example.handlingapi.exception.UserNotFoundHandler;
import com.example.handlingapi.model.Category;
import com.example.handlingapi.model.dto.CategoryDTO;
import com.example.handlingapi.model.mapper.CategoryMapper;
import com.example.handlingapi.model.request.CategoryRequest;
import com.example.handlingapi.repository.CategoryRepository;
import com.example.handlingapi.service.CategoryService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryImp implements CategoryService {

    private final CategoryRepository categoryRepository;
    private final CategoryMapper categoryMapper;

    public CategoryImp(CategoryRepository categoryRepository, CategoryMapper categoryMapper) {
        this.categoryRepository = categoryRepository;
        this.categoryMapper = categoryMapper;
    }

    @Override
    public List<Category> getAllCategories() {
        return categoryRepository.getAllCategories();
    }

    @Override
    public Category getCategoryById(Integer categoryId) {
        Category category = categoryRepository.getCategoryById(categoryId);
//        System.out.println("Get by id: "+category);

//        CategoryDTO categoryDTO = new CategoryDTO();
//
//        if (category == null){
//            throw new UserNotFoundHandler("Category "+ categoryId +" Not found");
//        }
//        return categoryMapper.categoryDTO(category);

        if(category == null){
//            System.out.println("In category category: null");
            throw new UserNotFoundHandler("Category "+ categoryId +" Not found");
        } else {
            return category;
        }

    }

    @Override
    public Category addNewCategory(CategoryRequest categoryRequest) {
        if (categoryRequest.getCategoryName().isBlank()){
            throw new BlankFieldHandler("Field categoryName is Empty");
        }
        return categoryRepository.addNewCategory(categoryRequest);
    }

    @Override
    public boolean deleteCategoryById(Integer categoryId) {
        CategoryDTO categoryDTO = new CategoryDTO();
        if (!categoryRepository.deleteCategoryById(categoryId)){
            throw new UserNotFoundHandler("Category "+ categoryId +" Not found");
        }
        return categoryRepository.deleteCategoryById(categoryId);
    }

    @Override
    public Integer updateCategoryById(Integer categoryId, CategoryRequest categoryRequest) {
        Category category = categoryRepository.getCategoryById(categoryId);
//        System.out.println(category);
        if (category== null){
//            System.out.println("In category");
            throw new UserNotFoundHandler("Category "+ categoryId +" Not found");
        } else {
            return categoryRepository.updateCategoryById(categoryId, categoryRequest);
        }
    }

}
