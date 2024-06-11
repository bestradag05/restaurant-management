package com.iroman.restaurantmanagement.application.service;

import com.iroman.restaurantmanagement.application.dto.category.CategoryDto;
import com.iroman.restaurantmanagement.application.dto.category.CategorySmallDto;


import java.util.List;

public interface CategoryService {


    List<CategorySmallDto> findAll();
    CategoryDto findById(Long id);

}
