package com.e.restaurant.dao;

import com.e.restaurant.database.repository.DishRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("dishMysql")
public class DishDatabaseDao implements DishDao {

    private DishRepository repository;

    @Autowired
    public DishDatabaseDao(DishRepository repository) {
        this.repository = repository;
    }
}
