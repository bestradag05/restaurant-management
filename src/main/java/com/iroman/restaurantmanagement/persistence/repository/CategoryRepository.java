package com.iroman.restaurantmanagement.persistence.repository;

import com.iroman.restaurantmanagement.persistence.entity.Category;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CategoryRepository extends ListCrudRepository<Category, Long> {

    List<Category> findByStateOrderByIdDesc(String state);

    @Query(value = "SELECT c FROM Category c " +
            "WHERE UPPER(c.name) LIKE UPPER(CONCAT('%', :name, '%')) " +
            "ORDER BY c.id DESC"
    )
    List<Category> findByName(@Param("name") String name);

//    @Query(value = "SELECT c FROM Category c WHERE UPPER(c.name) LIKE UPPER(CONCAT('%', :name, '%'))")
//    List<Category> findByName(@Param("name") String name);



}
