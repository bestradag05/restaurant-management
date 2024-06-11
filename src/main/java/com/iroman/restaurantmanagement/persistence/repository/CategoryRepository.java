package com.iroman.restaurantmanagement.persistence.repository;

import com.iroman.restaurantmanagement.persistence.entity.Category;
import org.springframework.data.repository.ListCrudRepository;

import java.util.List;

public interface CategoryRepository extends ListCrudRepository<Category, Long> {

    List<Category> findByStateOrderByIdDesc(String state);
}
