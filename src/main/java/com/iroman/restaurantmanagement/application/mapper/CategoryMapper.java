package com.iroman.restaurantmanagement.application.mapper;

import com.iroman.restaurantmanagement.application.dto.category.CategoryBodyDto;
import com.iroman.restaurantmanagement.application.dto.category.CategoryDto;
import com.iroman.restaurantmanagement.application.dto.category.CategorySaveDto;
import com.iroman.restaurantmanagement.application.dto.category.CategorySmallDto;
import com.iroman.restaurantmanagement.persistence.entity.Category;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.MappingTarget;

//MapStruct annotations
@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface CategoryMapper {

    CategoryDto toDto(Category category);

    CategorySmallDto toSmallDto(Category category);

    CategorySaveDto toSavedDto(Category category);

    Category toEntity(CategoryBodyDto categoryBodyDto);

    Category updateEntity(@MappingTarget Category category, CategoryBodyDto categoryBodyDto);

}
