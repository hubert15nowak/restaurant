package com.e.restaurant.dao;

import com.e.restaurant.database.repository.BillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("storeroomMysql")
public class StoreroomDatabaseDao implements StoreroomDao {

    private BillRepository repository;

    @Autowired
    public StoreroomDatabaseDao(BillRepository repository) {
        this.repository = repository;
    }
}
