package com.e.restaurant.dto.restaurant;

import com.e.restaurant.database.entity.Restaurant;

public class CreateRestaurantDto {
    public String name;

    public Restaurant mapToDao() {
        return new Restaurant(name);
    }
}
