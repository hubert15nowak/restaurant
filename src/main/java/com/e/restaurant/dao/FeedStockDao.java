package com.e.restaurant.dao;

import com.e.restaurant.database.entity.FeedStock;

import java.util.Optional;

public interface FeedStockDao {

    Optional<FeedStock> getById(FeedStock.FeedStockPK id);

    void add(FeedStock feedStock);

    Iterable<FeedStock> getAll();
}
