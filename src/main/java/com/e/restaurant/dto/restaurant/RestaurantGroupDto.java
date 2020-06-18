package com.e.restaurant.dto.restaurant;

import com.e.restaurant.database.entity.Restaurant;

import java.util.UUID;

public class RestaurantGroupDto {

    public UUID id;


    public RestaurantGroupDto(UUID restaurant) {
        id = restaurant;
    }

    public Restaurant mapToDao() {
        return new Restaurant(id);
    }

    public static RestaurantGroupDto mapToDto(Restaurant restaurant) {
        return new RestaurantGroupDto(restaurant.getId());
    }
}
