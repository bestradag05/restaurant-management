package com.iroman.restaurantmanagement.application.mapper;

import com.iroman.restaurantmanagement.application.dto.category.CategoryBodyDto;
import com.iroman.restaurantmanagement.application.dto.category.CategoryDto;
import com.iroman.restaurantmanagement.application.dto.category.CategorySmallDto;
import com.iroman.restaurantmanagement.persistence.entity.Category;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

//MapStruct annotations
@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface CategoryMapper {

    CategoryDto toDto(Category category);

    CategorySmallDto toSmallDto(Category category);

    Category toEntity(CategoryBodyDto categoryBodyDto);
}
