package com.e.restaurant.dao;

import com.e.restaurant.database.repository.BillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("dishMysql")
public class DishDatabaseDao implements DishDao {

    private BillRepository repository;

    @Autowired
    public DishDatabaseDao(BillRepository repository) {
        this.repository = repository;
    }
}
