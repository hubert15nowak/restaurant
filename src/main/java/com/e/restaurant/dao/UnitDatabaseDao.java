package com.e.restaurant.dao;

import com.e.restaurant.database.repository.BillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("unitMysql")
public class UnitDatabaseDao implements UnitDao {

    private BillRepository repository;

    @Autowired
    public UnitDatabaseDao(BillRepository repository) {
        this.repository = repository;
    }
}
