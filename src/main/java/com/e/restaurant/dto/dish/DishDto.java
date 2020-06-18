package com.e.restaurant.dto.dish;

import com.e.restaurant.database.entity.Dish;
import com.e.restaurant.dto.dishType.DishTypeDto;
import com.e.restaurant.dto.dishType.DishTypeGroupDto;
import com.e.restaurant.dto.restaurant.RestaurantDto;
import com.e.restaurant.dto.restaurant.RestaurantGroupDto;

import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

public class DishDto {

    public UUID id;
    public String name;
    public double price;
    public boolean inMenu;
    public RestaurantGroupDto restaurant;
    public Set<DishTypeGroupDto> dishType;


    public static DishDto mapToDto(Dish dish) {
        return new DishDto(
                dish.getId(),
                dish.getName(),
                dish.getPrice(),
                dish.isInMenu(),
                RestaurantGroupDto.mapToDto(dish.getRestaurant()),
                dish.getDishType().stream().map(DishTypeGroupDto::mapToDto).collect(Collectors.toSet()));
    }

    public DishDto(UUID id, String name, double price, boolean inMenu, RestaurantGroupDto restaurant, Set<DishTypeGroupDto> dishType) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.inMenu = inMenu;
        this.restaurant = restaurant;
        this.dishType = dishType;
    }


}
