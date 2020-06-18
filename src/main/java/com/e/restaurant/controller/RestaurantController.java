package com.e.restaurant.controller;

import com.e.restaurant.dto.restaurant.CreateRestaurantDto;
import com.e.restaurant.dto.restaurant.RestaurantDto;
import com.e.restaurant.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/v1/restaurant")
public class RestaurantController {

    private RestaurantService restaurantService;

    @Autowired
    public RestaurantController(RestaurantService restaurantService) {
        this.restaurantService = restaurantService;
    }

    @PostMapping
    public @ResponseBody
    ResponseEntity<CreateRestaurantDto> createRestaurant(@RequestBody CreateRestaurantDto restaurantDto) {
        try {
            restaurantService.createRestaurant(restaurantDto);
        } catch (DataIntegrityViolationException e) {
            return new ResponseEntity<CreateRestaurantDto>(restaurantDto, HttpStatus.CONFLICT);
        }
        return new ResponseEntity<CreateRestaurantDto>(restaurantDto, HttpStatus.CREATED);
    }

    @GetMapping
    public @ResponseBody
    Iterable<RestaurantDto> getRestaurants() {
        return restaurantService.getRestaurants();
    }
}
