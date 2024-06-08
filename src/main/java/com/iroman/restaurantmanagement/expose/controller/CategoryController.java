package com.iroman.restaurantmanagement.expose.controller;

//Anotaciones de Spring

import com.iroman.restaurantmanagement.application.service.CategoryService;
import com.iroman.restaurantmanagement.persistence.entity.Category;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/categories")
public class CategoryController {

    private CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping
    public List<Category> findAll(){

        return categoryService.findAll();

    }

    @GetMapping("/{id}")
    public Category findById(@PathVariable("id") Long id)
    {
        return categoryService.findById(id);
    }


}
