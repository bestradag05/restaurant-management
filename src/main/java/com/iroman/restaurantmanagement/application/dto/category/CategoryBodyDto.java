package com.iroman.restaurantmanagement.application.dto.category;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CategoryBodyDto {

    @NotBlank(message =  "Name is required")
    @Size(min = 3, max = 255, message = "Name must be between 3 and 255 characters")
    private String name;


    @Size(max = 255, message = "Description must be between 3 and 255 characters")
    private String description;

}
