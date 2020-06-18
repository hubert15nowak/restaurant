package com.e.restaurant.dto.restaurantTable;

import com.e.restaurant.database.entity.Reservation;
import com.e.restaurant.database.entity.RestaurantTable;
import com.e.restaurant.dto.restaurant.RestaurantDto;

import java.util.Set;

public class CreateRestaurantTableDto {

    public int seats;

    public String name;

    public RestaurantDto restaurant;

    public Set<Reservation> reservations;

    public RestaurantTable mapToDao() {
        RestaurantTable restaurantTable = new RestaurantTable(name, seats, restaurant.mapToDao());

        return restaurantTable;

    }
}
