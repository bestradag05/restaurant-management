package com.iroman.restaurantmanagement.application.service;

import com.iroman.restaurantmanagement.persistence.entity.Category;

import java.util.List;

public interface CategoryService {


    List<Category> findAll();
    Category findById(Long id);

}
