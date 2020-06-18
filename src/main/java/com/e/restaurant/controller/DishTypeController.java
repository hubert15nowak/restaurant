package com.e.restaurant.controller;

import com.e.restaurant.dto.dishType.CreateDishTypeDto;
import com.e.restaurant.dto.dishType.DishTypeDto;
import com.e.restaurant.service.DishTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Controller
@RequestMapping("/v1/dish-type")
public class DishTypeController {

    private DishTypeService dishTypeService;

    @Autowired
    public DishTypeController(DishTypeService dishTypeService) {
        this.dishTypeService = dishTypeService;
    }

    @PostMapping
    public @ResponseBody
    ResponseEntity<CreateDishTypeDto> createDishType(@RequestBody CreateDishTypeDto dishTypeDto) {
        try {
            dishTypeService.createDishType(dishTypeDto);
        } catch (DataIntegrityViolationException e) {
            return new ResponseEntity<CreateDishTypeDto>(dishTypeDto, HttpStatus.CONFLICT);
        }
        return new ResponseEntity<CreateDishTypeDto>(dishTypeDto, HttpStatus.CREATED);
    }

    @GetMapping
    public @ResponseBody
    Iterable<DishTypeDto> getDishTypes() {
        return dishTypeService.getDishTypes();
    }

    @GetMapping("/{uuid}")
    public @ResponseBody
    ResponseEntity<DishTypeDto> getDishType(@PathVariable UUID uuid) {
        DishTypeDto dishTypeDto = dishTypeService.getDishTypeDto(uuid);
        if (dishTypeDto != null) {
            return new ResponseEntity<DishTypeDto>(dishTypeDto, HttpStatus.OK);
        } else {
            return new ResponseEntity<DishTypeDto>(HttpStatus.NOT_FOUND);
        }
    }
}