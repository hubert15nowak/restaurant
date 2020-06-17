package com.e.restaurant.dao;

import com.e.restaurant.database.entity.Restaurant;
import com.e.restaurant.database.repository.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("restaurantMysql")
public class RestaurantDatabaseDao implements RestaurantDao {

    private RestaurantRepository repository;

    @Autowired
    public RestaurantDatabaseDao(RestaurantRepository repository) {
        this.repository = repository;
    }

    @Override
    public void saveRestaurant(Restaurant restaurant) {
        repository.save(restaurant);
    }

    @Override
    public Iterable<Restaurant> getRestaurants() {
        return repository.findAll();
    }


}
