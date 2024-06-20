package com.iroman.restaurantmanagement.shared.exception.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//Lombook annotations
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GeneralError {
    private String message;
}
