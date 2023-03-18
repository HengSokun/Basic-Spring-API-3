package com.example.handlingapi.model.mapper;

import com.example.handlingapi.model.Category;
import com.example.handlingapi.model.dto.CategoryDTO;
import org.mapstruct.Mapper;

@Mapper
public interface CategoryMapper {
    CategoryDTO categoryDTO(Category category);
}
