package com.e.restaurant.dao;

import com.e.restaurant.database.repository.StoreroomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("storeroomMysql")
public class StoreroomDatabaseDao implements StoreroomDao {

    private StoreroomRepository repository;

    @Autowired
    public StoreroomDatabaseDao(StoreroomRepository repository) {
        this.repository = repository;
    }
}
