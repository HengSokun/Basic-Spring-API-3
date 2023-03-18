package com.example.handlingapi;

import com.example.handlingapi.model.mapper.CategoryMapper;
import com.example.handlingapi.model.mapper.CategoryMapperImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfiguration {
    @Bean
    public CategoryMapper categoryMapper(){
        return new CategoryMapperImpl();
    }
}
