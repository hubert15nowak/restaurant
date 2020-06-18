package com.e.restaurant.dao;

import com.e.restaurant.database.entity.DishType;

import java.util.Optional;
import java.util.UUID;

public interface DishTypeDao {
    void saveDishType(DishType dishType);

    Optional<DishType> getDishType(UUID id);

    Iterable<DishType> getDishTypes();
}
