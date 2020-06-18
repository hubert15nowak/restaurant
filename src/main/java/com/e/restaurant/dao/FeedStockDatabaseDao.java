package com.e.restaurant.dao;

import com.e.restaurant.database.entity.FeedStock;
import com.e.restaurant.database.repository.FeedStockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository("feedStockMysql")
public class FeedStockDatabaseDao implements FeedStockDao {

    private FeedStockRepository repository;

    @Autowired
    public FeedStockDatabaseDao(FeedStockRepository repository) {
        this.repository = repository;
    }

    @Override
    public Optional<FeedStock> getById(FeedStock.FeedStockPK id) {
        return repository.getFirstById(id);
    }

    @Override
    public void add(FeedStock feedStock) {
        repository.save(feedStock);
    }

    @Override
    public Iterable<FeedStock> getAll() {
        return repository.findAll();
    }
}
