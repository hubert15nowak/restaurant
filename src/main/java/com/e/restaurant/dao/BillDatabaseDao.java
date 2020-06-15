package com.e.restaurant.dao;

import com.e.restaurant.database.repository.BillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("billMysql")
public class BillDatabaseDao implements BillDao{

    private BillRepository repository;

    @Autowired
    public BillDatabaseDao(BillRepository repository) {
        this.repository = repository;
    }
}
