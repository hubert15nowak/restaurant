package com.e.restaurant.dao;

import com.e.restaurant.database.repository.BillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("restaurantTableMysql")
public class RestaurantTableDatabaseDao implements RestaurantTableDao {

    private BillRepository repository;

    @Autowired
    public RestaurantTableDatabaseDao(BillRepository repository) {
        this.repository = repository;
    }
}
