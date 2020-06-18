package com.e.restaurant.dao;

import com.e.restaurant.database.entity.RestaurantTable;

import java.util.Optional;
import java.util.UUID;

public interface RestaurantTableDao {
    public void saveRestaurantTable(RestaurantTable restaurantTable);

    Iterable<RestaurantTable> getRestaurantTables();

    Optional<RestaurantTable> getRestaurantTable(UUID id);
}