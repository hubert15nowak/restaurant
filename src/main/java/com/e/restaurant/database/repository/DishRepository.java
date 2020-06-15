package com.e.restaurant.database.repository;

import com.e.restaurant.database.entity.Dish;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface DishRepository extends CrudRepository<Dish, UUID> {
}