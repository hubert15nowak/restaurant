package com.e.restaurant.controller;

import com.e.restaurant.dto.dish.CreateDishDto;
import com.e.restaurant.dto.dish.DishDto;
import com.e.restaurant.service.DishService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Controller
@RequestMapping("/v1/dish")
public class DishController {

    private DishService dishService;

    @Autowired
    public DishController(DishService dishService) {
        this.dishService = dishService;
    }

    @PostMapping
    public @ResponseBody
    ResponseEntity<CreateDishDto> createDish(@RequestBody CreateDishDto dishDto) {
        try {
            dishService.createDish(dishDto);
        } catch (DataIntegrityViolationException e) {
            return new ResponseEntity<CreateDishDto>(dishDto, HttpStatus.CONFLICT);
        }
        return new ResponseEntity<CreateDishDto>(dishDto, HttpStatus.CREATED);
    }

    @GetMapping
    public @ResponseBody
    Iterable<DishDto> getDishs() {
        return dishService.getDishes();
    }

    @GetMapping("/{id}")
    public @ResponseBody
    ResponseEntity<DishDto> getDish(@PathVariable UUID id) {
        DishDto dishDto = dishService.getDishDto(id);
        if (dishDto != null) {
            return new ResponseEntity<DishDto>(dishDto, HttpStatus.OK);
        } else {
            return new ResponseEntity<DishDto>(HttpStatus.NOT_FOUND);
        }
    }
}