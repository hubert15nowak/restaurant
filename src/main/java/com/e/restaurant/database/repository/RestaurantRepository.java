package com.e.restaurant.database.repository;


import com.e.restaurant.database.entity.Restaurant;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;
import java.util.UUID;

public interface RestaurantRepository extends CrudRepository<Restaurant, UUID> {

    public Optional<Restaurant> findFirstByName(String name);
}