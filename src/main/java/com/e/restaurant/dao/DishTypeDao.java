package com.e.restaurant.dao;

import com.e.restaurant.database.entity.DishType;

import java.util.Optional;

public interface DishTypeDao {
    void saveDishType(DishType dishType);

    Optional<DishType> getDishType(String name);

    Iterable<DishType> getDishTypes();
}
