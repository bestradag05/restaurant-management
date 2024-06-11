package com.iroman.restaurantmanagement.application.service;

import com.iroman.restaurantmanagement.application.dto.category.CategoryBodyDto;
import com.iroman.restaurantmanagement.application.dto.category.CategoryDto;
import com.iroman.restaurantmanagement.application.dto.category.CategorySaveDto;
import com.iroman.restaurantmanagement.application.dto.category.CategorySmallDto;


import java.util.List;

public interface CategoryService {


    List<CategorySmallDto> findAll();
    CategoryDto findById(Long id);
    CategorySaveDto create(CategoryBodyDto categoryBodyDto);
    CategorySaveDto update(Long id, CategoryBodyDto categoryBodyDto);
    CategorySaveDto disable(Long id);

    List<CategorySmallDto> finByState(String state);
}
