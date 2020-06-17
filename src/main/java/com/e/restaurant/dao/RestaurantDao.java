package com.e.restaurant.dao;


import com.e.restaurant.database.entity.Restaurant;

public interface RestaurantDao {

    public void saveRestaurant(Restaurant restaurant);

    Iterable<Restaurant> getRestaurants();
}
