package com.example.handlingapi.repository;

import com.example.handlingapi.model.Category;
import com.example.handlingapi.model.request.CategoryRequest;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface CategoryRepository {

    @Select("SELECT * FROM categories")
    @Result(property = "categoryId", column = "category_id")
    @Result(property = "categoryName", column = "category_name")
    List<Category> getAllCategories();

    @Select("SELECT * FROM categories WHERE category_id = #{categoryId}")
    @Result(property = "categoryId", column = "category_id")
    @Result(property = "categoryName", column = "category_name")
    Category getCategoryById(Integer categoryId);

    @Select("INSERT INTO categories(category_name) VALUES(#{categoryRequest.categoryName})")
    @Result(property = "categoryId", column = "category_id")
    @Result(property = "categoryName", column = "category_name")
    Category addNewCategory(@Param("categoryRequest") CategoryRequest categoryRequest);

    @Delete("DELETE FROM categories WHERE category_id = #{categoryId}")
    @Result(property = "categoryId", column = "category_id")
    @Result(property = "categoryName", column = "category_name")
    boolean deleteCategoryById(@Param("categoryId") Integer categoryId);

    @Update("UPDATE categories " +
            "SET category_name = #{categoryRequest.categoryName} " +
            "WHERE category_id = #{categoryId} ")
    Integer updateCategoryById(@Param("categoryId") Integer categoryId,@Param("categoryRequest") CategoryRequest categoryRequest);
}
