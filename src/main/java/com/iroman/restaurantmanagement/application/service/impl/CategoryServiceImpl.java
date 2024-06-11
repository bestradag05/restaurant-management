package com.iroman.restaurantmanagement.application.service.impl;


import com.iroman.restaurantmanagement.application.dto.category.CategoryDto;
import com.iroman.restaurantmanagement.application.dto.category.CategorySmallDto;
import com.iroman.restaurantmanagement.application.mapper.CategoryMapper;
import com.iroman.restaurantmanagement.application.service.CategoryService;
import com.iroman.restaurantmanagement.persistence.entity.Category;
import com.iroman.restaurantmanagement.persistence.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

//Lombok annotations
@RequiredArgsConstructor

//Spring Stereotype annotation
@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;
    private final CategoryMapper categoryMapper;


    @Override
    public List<CategorySmallDto> findAll() {

        return ((List<Category>) categoryRepository.findAll())
                .stream()
                .map(categoryMapper::toSmallDto)
                .toList();

    }

    @Override
    public CategoryDto findById(Long id) {
        // Programacion imperativa

        //        Category category = categoryRepository.findById(id).orElse(null);
        //        return categoryMapper.toDto(category);


        //Programacion funcional

        return categoryRepository.findById(id)
                .map(category -> categoryMapper.toDto(category))
                .orElse(null);

    }
}
