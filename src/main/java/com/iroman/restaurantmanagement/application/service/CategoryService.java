package com.iroman.restaurantmanagement.application.service;

import com.iroman.restaurantmanagement.application.dto.category.CategoryBodyDto;
import com.iroman.restaurantmanagement.application.dto.category.CategoryDto;
import com.iroman.restaurantmanagement.application.dto.category.CategorySaveDto;
import com.iroman.restaurantmanagement.application.dto.category.CategorySmallDto;
import com.iroman.restaurantmanagement.persistence.entity.Category;
import com.iroman.restaurantmanagement.shared.exception.DataNotFoundException;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


import java.util.List;

public interface CategoryService {


    List<CategorySmallDto> findAll();
    CategoryDto findById(Long id) throws DataNotFoundException;
    CategorySaveDto create(CategoryBodyDto categoryBodyDto);
    CategorySaveDto update(Long id, CategoryBodyDto categoryBodyDto) throws DataNotFoundException;
    CategorySaveDto disable(Long id) throws DataNotFoundException;

    List<CategorySmallDto> finByState(String state);

    List<CategorySmallDto> findByName(String name);

    List<CategorySmallDto> findAllByFilters(String name, String state);
}
