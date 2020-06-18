package com.e.restaurant.dao;

import com.e.restaurant.database.entity.Dish;

import java.util.Optional;
import java.util.UUID;

public interface DishDao {
    void saveDish(Dish dish);

    Optional<Dish> getDish(UUID id);

    Iterable<Dish> getDishs();
}
