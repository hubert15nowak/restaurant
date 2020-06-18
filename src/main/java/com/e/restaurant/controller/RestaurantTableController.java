package com.e.restaurant.controller;

import com.e.restaurant.dto.restaurantTable.CreateRestaurantTableDto;
import com.e.restaurant.dto.restaurantTable.RestaurantTableDto;
import com.e.restaurant.service.RestaurantTableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;


@Controller
@RequestMapping("/v1/restaurant-table")
public class RestaurantTableController {

    private RestaurantTableService restaurantTableService;

    @Autowired
    public RestaurantTableController(RestaurantTableService restaurantTableService) {
        this.restaurantTableService = restaurantTableService;
    }

    @PostMapping
    public @ResponseBody
    ResponseEntity<CreateRestaurantTableDto> createRestaurantTable(@RequestBody CreateRestaurantTableDto restaurantTableDto) {
        try {
            restaurantTableService.createRestaurantTable(restaurantTableDto);
        } catch (DataIntegrityViolationException e) {
            return new ResponseEntity<CreateRestaurantTableDto>(restaurantTableDto, HttpStatus.CONFLICT);
        }
        return new ResponseEntity<CreateRestaurantTableDto>(restaurantTableDto, HttpStatus.CREATED);
    }

    @GetMapping
    public @ResponseBody
    Iterable<RestaurantTableDto> getRestaurantTables() {
        return restaurantTableService.getRestaurantTables();
    }

    @GetMapping("/{id}")
    public @ResponseBody
    ResponseEntity<RestaurantTableDto> getRestaurantTable(@PathVariable UUID id) {
        RestaurantTableDto restaurantTableDto = restaurantTableService.getRestaurantTableDto(id);
        if (restaurantTableDto != null) {
            return new ResponseEntity<RestaurantTableDto>(restaurantTableDto, HttpStatus.OK);
        } else {
            return new ResponseEntity<RestaurantTableDto>(HttpStatus.NOT_FOUND);
        }
    }
}