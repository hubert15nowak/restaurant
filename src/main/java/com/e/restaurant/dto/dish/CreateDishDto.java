package com.e.restaurant.dto.dish;

import com.e.restaurant.database.entity.Dish;
import com.e.restaurant.database.entity.DishType;
import com.e.restaurant.dto.dishType.DishTypeDto;
import com.e.restaurant.dto.restaurant.RestaurantDto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

public class CreateDishDto {

    public String name;
    public double price;
    public boolean inMenu;
    public UUID restaurant;
    public List<UUID> dishTypes;

    public Dish mapToDao() {
        Dish dish = new Dish();
        dish.setName(name);
        dish.setPrice(price);
        dish.setInMenu(inMenu);
        dish.setRestaurant((new RestaurantDto(restaurant)).mapToDao());
        Set<DishType> collect = dishTypes.stream().map(d ->
                (new DishTypeDto(d)).mapToDao())
                .collect(Collectors.toSet());
        dish.setDishType(collect);
        return dish;
    }
}
