package com.e.restaurant.dto.dish;

import com.e.restaurant.database.entity.Dish;
import com.e.restaurant.dto.dishType.DishTypeGroupDto;
import com.e.restaurant.dto.restaurant.RestaurantDto;

import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

public class DishGroupDto {

    public UUID id;
    public String name;
    public double price;
    public boolean inMenu;
    public UUID restaurant;


    public static DishGroupDto mapToDto(Dish dish) {
        return new DishGroupDto(
                dish.getId(),
                dish.getName(),
                dish.getPrice(),
                dish.isInMenu(),
                RestaurantDto.mapToDto(dish.getRestaurant()));
    }

    public DishGroupDto(UUID id, String name, double price, boolean inMenu, RestaurantDto restaurant) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.inMenu = inMenu;
        this.restaurant = restaurant.id;
    }
}
