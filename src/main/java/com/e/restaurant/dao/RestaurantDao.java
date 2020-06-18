package com.e.restaurant.dao;


import com.e.restaurant.database.entity.Restaurant;

import java.util.Optional;

public interface RestaurantDao {

    public void saveRestaurant(Restaurant restaurant);

    Iterable<Restaurant> getRestaurants();

    Optional<Restaurant> getRestaurant(String name);
}
