package com.e.restaurant.dto.restaurantTable;

import com.e.restaurant.database.entity.Reservation;
import com.e.restaurant.database.entity.RestaurantTable;
import com.e.restaurant.dto.restaurant.RestaurantDto;

import java.util.Set;
import java.util.UUID;

public class RestaurantTableDto {

    public UUID id;
    public int seats;
    public String name;
    public RestaurantDto restaurant;
    public Set<Reservation> reservations;

    public RestaurantTableDto(UUID id, String name, int seats, RestaurantDto restaurant) {
        this.id = id;
        this.name = name;
        this.seats = seats;
        this.restaurant = restaurant;
    }


    public static RestaurantTableDto mapToDto(RestaurantTable restaurantTable) {
        return new RestaurantTableDto(
                restaurantTable.getId(),
                restaurantTable.getName(),
                restaurantTable.getSeats(),
                RestaurantDto.mapToDto(restaurantTable.getRestaurant()));
    }

}
