package com.e.restaurant.dao;

import com.e.restaurant.database.repository.BillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("restaurantMysql")
public class RestaurantDatabaseDao implements RestaurantDao {

    private BillRepository repository;

    @Autowired
    public RestaurantDatabaseDao(BillRepository repository) {
        this.repository = repository;
    }
}
