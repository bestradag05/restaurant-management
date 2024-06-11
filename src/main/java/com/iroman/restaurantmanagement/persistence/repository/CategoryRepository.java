package com.iroman.restaurantmanagement.persistence.repository;

import com.iroman.restaurantmanagement.persistence.entity.Category;
import org.springframework.data.repository.ListCrudRepository;

public interface CategoryRepository extends ListCrudRepository<Category, Long> {

}
