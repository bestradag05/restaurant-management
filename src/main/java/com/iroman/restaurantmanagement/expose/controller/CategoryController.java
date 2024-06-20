package com.iroman.restaurantmanagement.expose.controller;

//Anotaciones de Spring

import com.iroman.restaurantmanagement.application.dto.category.CategoryBodyDto;
import com.iroman.restaurantmanagement.application.dto.category.CategoryDto;
import com.iroman.restaurantmanagement.application.dto.category.CategorySaveDto;
import com.iroman.restaurantmanagement.application.dto.category.CategorySmallDto;
import com.iroman.restaurantmanagement.application.service.CategoryService;
import com.iroman.restaurantmanagement.shared.constant.StatusCode;
import com.iroman.restaurantmanagement.shared.exception.DataNotFoundException;
import com.iroman.restaurantmanagement.shared.exception.model.ArgumentNotValidError;
import com.iroman.restaurantmanagement.shared.exception.model.GeneralError;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//Lombok Annotations
@RequiredArgsConstructor

// Spring Stereotype annotation
@RestController
@RequestMapping("/categories")
public class CategoryController {

    private final CategoryService categoryService;

    @ApiResponse(responseCode = StatusCode.OK, description = "List of all categories")
    @GetMapping
    public ResponseEntity<List<CategorySmallDto>> findAll() {

        return ResponseEntity.status(HttpStatus.OK)
                .body(categoryService.findAll());

    }



    @ApiResponse(responseCode = StatusCode.OK, description = "Category by id")
    @ApiResponse(
            responseCode = StatusCode.NOT_FOUND,
            description = "Category by id",
            content = @Content(
                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                    schema = @Schema(implementation = GeneralError.class)
            )
    )
    @GetMapping("/{id}")
    public ResponseEntity<CategoryDto>  findById(@PathVariable("id") Long id) throws DataNotFoundException {
        return ResponseEntity.status(HttpStatus.OK)
                .body(categoryService.findById(id));
    }



    @ApiResponse(responseCode = StatusCode.OK, description = "List of categories by state")
    @GetMapping("/state/{state}")
    public ResponseEntity<List<CategorySmallDto>>  finByState(@PathVariable("state") String state){
        return ResponseEntity.status(HttpStatus.OK)
                .body(categoryService.finByState(state));
    }



    @ApiResponse(responseCode = StatusCode.OK, description = "List of categories by name")
    @GetMapping("/name/{name}")
    public ResponseEntity<List<CategorySmallDto>>  findByName(@PathVariable("name") String name){
        return ResponseEntity.status(HttpStatus.OK)
                .body(categoryService.findByName(name));
    }



    @ApiResponse(responseCode = StatusCode.OK, description = "List of categories by filters")
    @GetMapping("/filters")
    public ResponseEntity<List<CategorySmallDto>> findAllByFilters(@RequestParam(value = "name", required = false) String name,
                                                   @RequestParam(value = "state", required = false) String state){
        return ResponseEntity.status(HttpStatus.OK)
                .body(categoryService.findAllByFilters(name, state));
    }


    @ApiResponse(responseCode = StatusCode.CREATED, description = "Category created")
    @ApiResponse(
            responseCode = StatusCode.BAD_REQUEST,
            description = "Invalid data",
            content = @Content(
                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                    schema = @Schema(implementation = ArgumentNotValidError.class)
            )
    )
    @PostMapping
    public ResponseEntity<CategorySaveDto> create(@Valid @RequestBody CategoryBodyDto categoryBodyDto) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(categoryService.create(categoryBodyDto));
    }



    @ApiResponse(responseCode = StatusCode.OK, description = "Category updated")
    @ApiResponse(
            responseCode = StatusCode.NOT_FOUND,
            description = "Category not found",
            content = @Content(
                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                    schema = @Schema(implementation = GeneralError.class)
            )
    )
    @ApiResponse(
            responseCode = StatusCode.BAD_REQUEST,
            description = "Invalid data",
            content = @Content(
                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                    schema = @Schema(implementation = ArgumentNotValidError.class)
            )
    )
    @PutMapping("/{id}")
    public ResponseEntity<CategorySaveDto> update(@PathVariable("id") Long id,@Valid  @RequestBody CategoryBodyDto categoryBodyDto) throws DataNotFoundException {
        return ResponseEntity.status(HttpStatus.OK)
                .body(categoryService.update(id, categoryBodyDto));
    }


    @ApiResponse(responseCode = StatusCode.OK, description = "Category disabled")
    @ApiResponse(
            responseCode = StatusCode.NOT_FOUND,
            description = "Category not found",
            content = @Content(
                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                    schema = @Schema(implementation = GeneralError.class)
            )
    )
    @DeleteMapping("/{id}")
    public ResponseEntity<CategorySaveDto> disabled(@PathVariable("id") Long id) throws DataNotFoundException{
        return ResponseEntity.status(HttpStatus.OK)
                .body(categoryService.disable(id));
    }

}
