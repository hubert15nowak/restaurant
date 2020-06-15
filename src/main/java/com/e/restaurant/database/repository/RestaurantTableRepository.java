package com.e.restaurant.database.repository;


import com.e.restaurant.database.entity.RestaurantTable;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface RestaurantTableRepository extends CrudRepository<RestaurantTable, UUID> {
}