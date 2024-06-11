package com.iroman.restaurantmanagement.expose.controller;

//Anotaciones de Spring

import com.iroman.restaurantmanagement.application.dto.category.CategoryBodyDto;
import com.iroman.restaurantmanagement.application.dto.category.CategoryDto;
import com.iroman.restaurantmanagement.application.dto.category.CategorySaveDto;
import com.iroman.restaurantmanagement.application.dto.category.CategorySmallDto;
import com.iroman.restaurantmanagement.application.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//Lombok Annotations
@RequiredArgsConstructor

// Spring Stereotype annotation
@RestController
@RequestMapping("/categories")
public class CategoryController {

    private final CategoryService categoryService;


    @GetMapping
    public List<CategorySmallDto> findAll() {

        return categoryService.findAll();

    }

    @GetMapping("/{id}")
    public CategoryDto findById(@PathVariable("id") Long id) {
        return categoryService.findById(id);
    }

    @GetMapping("/state/{state}")
    public List<CategorySmallDto> finByState(@PathVariable("state") String state){
        return categoryService.finByState(state);
    }

    @GetMapping("/name/{name}")
    public  List<CategorySmallDto> findByName(@PathVariable("name") String name){
        return categoryService.findByName(name);
    }

    @GetMapping("/filters")
    public List<CategorySmallDto> findAllByFilters(@RequestParam(value = "name", required = false) String name,
                                                   @RequestParam(value = "state", required = false) String state){
        return categoryService.findAllByFilters(name, state);
    }


    @PostMapping
    public CategorySaveDto create(@RequestBody CategoryBodyDto categoryBodyDto) {
        return categoryService.create(categoryBodyDto);
    }

    @PutMapping("/{id}")
    public CategorySaveDto update(@PathVariable("id") Long id, @RequestBody CategoryBodyDto categoryBodyDto) {
        return categoryService.update(id, categoryBodyDto);
    }

    @DeleteMapping("/{id}")
    public CategorySaveDto disabled(@PathVariable("id") Long id) {
        return categoryService.disable(id);
    }

}
