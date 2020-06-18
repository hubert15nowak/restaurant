package com.e.restaurant.dao;

import com.e.restaurant.database.entity.RestaurantTable;
import com.e.restaurant.database.repository.RestaurantTableRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository("restaurantTableMysql")
public class RestaurantTableDatabaseDao implements RestaurantTableDao {

    private RestaurantTableRepository repository;

    @Autowired
    public RestaurantTableDatabaseDao(RestaurantTableRepository repository) {
        this.repository = repository;
    }


    @Override
    public void saveRestaurantTable(RestaurantTable restaurantTable) {
        repository.save(restaurantTable);
    }

    @Override
    public Iterable<RestaurantTable> getRestaurantTables() {
        return repository.findAll();
    }

    @Override
    public Optional<RestaurantTable> getRestaurantTable(UUID id) {
        return repository.findById(id);
    }


}
