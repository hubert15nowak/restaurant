package com.e.restaurant.dto.restaurant;

import com.e.restaurant.database.entity.Restaurant;

import javax.persistence.Column;
import java.util.UUID;

public class RestaurantDto {
    public UUID id;

    public String name;


    public RestaurantDto(UUID id, String name) {
        this.id = id;
        this.name = name;
    }

    public RestaurantDto(UUID restaurant) {
        id = restaurant;
    }

    public Restaurant mapToDao() {
        return new Restaurant(id, name);
    }

    public static RestaurantDto mapToDto(Restaurant restaurant) {
        return new RestaurantDto(restaurant.getId(), restaurant.getName());
    }
}
