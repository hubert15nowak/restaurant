package com.e.restaurant.dao;

import com.e.restaurant.database.repository.BillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("dishTypeMysql")
public class DishTypeDatabaseDao implements DishTypeDao {

    private BillRepository repository;

    @Autowired
    public DishTypeDatabaseDao(BillRepository repository) {
        this.repository = repository;
    }
}
