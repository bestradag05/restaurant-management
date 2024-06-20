package com.iroman.restaurantmanagement.application.service.impl;


import com.iroman.restaurantmanagement.application.dto.category.CategoryBodyDto;
import com.iroman.restaurantmanagement.application.dto.category.CategoryDto;
import com.iroman.restaurantmanagement.application.dto.category.CategorySaveDto;
import com.iroman.restaurantmanagement.application.dto.category.CategorySmallDto;
import com.iroman.restaurantmanagement.application.mapper.CategoryMapper;
import com.iroman.restaurantmanagement.application.service.CategoryService;
import com.iroman.restaurantmanagement.persistence.entity.Category;
import com.iroman.restaurantmanagement.persistence.repository.CategoryRepository;
import com.iroman.restaurantmanagement.shared.exception.DataNotFoundException;
import com.iroman.restaurantmanagement.shared.state.enums.State;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.function.Supplier;

//Lombok annotations
@RequiredArgsConstructor

//Spring Stereotype annotation
@Service
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;
    private final CategoryMapper categoryMapper;


    @Override
    public List<CategorySmallDto> findAll() {

        return categoryRepository.findAll()
                .stream()
                .map(categoryMapper::toSmallDto)
                .toList();

    }

    @Override
    public CategoryDto findById(Long id) throws DataNotFoundException {
        // Programacion imperativa

        //        Category category = categoryRepository.findById(id).orElse(null);
        //        return categoryMapper.toDto(category);


        //Programacion funcional

        return categoryRepository.findById(id)
                .map(category -> categoryMapper.toDto(category))
                .orElseThrow(() -> categoryDataNotFoundExceptionSupplier(id));

    }

    @Override
    public CategorySaveDto create(CategoryBodyDto categoryBodyDto) {
        Category category = categoryMapper.toEntity(categoryBodyDto);
        category.setState(State.ENABLED.getValue());
        category.setCreatedAt(LocalDateTime.now());

        return categoryMapper.toSavedDto(categoryRepository.save(category));
    }

    @Override
    public CategorySaveDto update(Long id, CategoryBodyDto categoryBodyDto)  throws DataNotFoundException{

        Category category = categoryRepository.findById(id)
                .orElseThrow(() -> categoryDataNotFoundExceptionSupplier(id));;

        categoryMapper.updateEntity(category, categoryBodyDto);
        category.setUpdatedAt(LocalDateTime.now());

        return categoryMapper.toSavedDto(categoryRepository.save(category));
    }


    private DataNotFoundException categoryDataNotFoundExceptionSupplier (Long id){
        return new DataNotFoundException("Category not found with id: " + id);
    }


    @Override
    public CategorySaveDto disable(Long id) throws DataNotFoundException {
        Category category = categoryRepository.findById(id)
                .orElseThrow(() -> categoryDataNotFoundExceptionSupplier(id));
        category.setState(State.DISABLED.getValue());


        return categoryMapper.toSavedDto(categoryRepository.save(category));
    }

    @Override
    public List<CategorySmallDto> finByState(String state) {

        return categoryRepository.findByStateOrderByIdDesc(state)
                .stream()
                .map(categoryMapper::toSmallDto)
                .toList();
    }

    @Override
    public List<CategorySmallDto> findByName(String name) {
        return categoryRepository.findByName(name)
                .stream()
                .map(categoryMapper::toSmallDto)
                .toList();
    }

    @Override
    public List<CategorySmallDto> findAllByFilters(String name, String state) {
        return categoryRepository.findAllByFilter(name, state)
                .stream()
                .map(categoryMapper::toSmallDto)
                .toList();
    }
}
