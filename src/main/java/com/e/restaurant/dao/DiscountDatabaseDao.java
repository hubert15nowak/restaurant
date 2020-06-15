package com.e.restaurant.dao;

import com.e.restaurant.database.repository.BillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("discountMysql")
public class DiscountDatabaseDao implements DiscountDao {

    private BillRepository repository;

    @Autowired
    public DiscountDatabaseDao(BillRepository repository) {
        this.repository = repository;
    }
}
