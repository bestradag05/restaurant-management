package com.iroman.restaurantmanagement.persistence.repository;

import com.iroman.restaurantmanagement.persistence.entity.Category;
import org.springframework.data.repository.CrudRepository;

public interface CategoryRepository extends CrudRepository<Category, Long> {

}
