package com.e.restaurant.dto.dish;

import com.e.restaurant.database.entity.Dish;
import com.e.restaurant.database.entity.DishType;
import com.e.restaurant.dto.restaurant.RestaurantDto;

import java.util.Set;
import java.util.UUID;

public class CreateDishDto {

    public UUID id;
    public String name;
    public double price;
    public boolean inMenu;
    public RestaurantDto restaurant;
    public Set<DishType> dishType; //TODO: change to Dto


    public Dish mapToDao() {
        Dish dish = new Dish();
        dish.setName(name);
        dish.setPrice(price);
        dish.setInMenu(inMenu);
        dish.setRestaurant(restaurant.mapToDao());
        dish.setDishType(dishType); //TODO: dunno if okay
        return dish;
    }
}
