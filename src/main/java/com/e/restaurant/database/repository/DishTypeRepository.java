package com.e.restaurant.database.repository;


import com.e.restaurant.database.entity.DishType;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;
import java.util.UUID;

public interface DishTypeRepository extends CrudRepository<DishType, UUID> {
    Optional<DishType> findFirstByName(String name);
}