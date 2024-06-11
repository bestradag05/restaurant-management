package com.iroman.restaurantmanagement.application.service.impl;


import com.iroman.restaurantmanagement.application.dto.category.CategoryBodyDto;
import com.iroman.restaurantmanagement.application.dto.category.CategoryDto;
import com.iroman.restaurantmanagement.application.dto.category.CategorySaveDto;
import com.iroman.restaurantmanagement.application.dto.category.CategorySmallDto;
import com.iroman.restaurantmanagement.application.mapper.CategoryMapper;
import com.iroman.restaurantmanagement.application.service.CategoryService;
import com.iroman.restaurantmanagement.persistence.entity.Category;
import com.iroman.restaurantmanagement.persistence.repository.CategoryRepository;
import com.iroman.restaurantmanagement.shared.state.enums.State;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
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

    @Override
    public CategorySaveDto create(CategoryBodyDto categoryBodyDto) {
        Category category = categoryMapper.toEntity(categoryBodyDto);
        category.setState(State.ENABLED.getValue());
        category.setCreatedAt(LocalDateTime.now());

        return categoryMapper.toSavedDto(categoryRepository.save(category));
    }

    @Override
    public CategorySaveDto update(Long id, CategoryBodyDto categoryBodyDto) {

        Category category = categoryRepository.findById(id).get();

        categoryMapper.updateEntity(category, categoryBodyDto);
        category.setUpdatedAt(LocalDateTime.now());

        return categoryMapper.toSavedDto(categoryRepository.save(category));
    }

    @Override
    public CategorySaveDto disable(Long id) {
        Category category = categoryRepository.findById(id).get();
        category.setState(State.DISABLED.getValue());


        return categoryMapper.toSavedDto(categoryRepository.save(category));
    }
}
