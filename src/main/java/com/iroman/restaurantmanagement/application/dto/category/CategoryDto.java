package com.iroman.restaurantmanagement.application.dto.category;

// Lombok annotations

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CategoryDto {
    private Long id;
    private String name;
    private String description;
    private String urlKey;
    private String state;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
