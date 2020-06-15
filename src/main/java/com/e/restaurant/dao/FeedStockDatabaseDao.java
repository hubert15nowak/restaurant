package com.e.restaurant.dao;

import com.e.restaurant.database.repository.FeedStockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("feedStockMysql")
public class FeedStockDatabaseDao implements FeedStockDao {

    private FeedStockRepository repository;

    @Autowired
    public FeedStockDatabaseDao(FeedStockRepository repository) {
        this.repository = repository;
    }
}
