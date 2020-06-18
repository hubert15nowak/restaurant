package com.e.restaurant.dao;

import com.e.restaurant.database.repository.DiscountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("discountMysql")
public class DiscountDatabaseDao implements DiscountDao {

    private DiscountRepository repository;

    @Autowired
    public DiscountDatabaseDao(DiscountRepository repository) {
        this.repository = repository;
    }
}
