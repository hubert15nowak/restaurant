package com.e.restaurant.database.repository;

import com.e.restaurant.database.entity.FeedStock;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface FeedStockRepository extends CrudRepository<FeedStock, FeedStock.FeedStockPK> {

    Optional<FeedStock> getFirstById(FeedStock.FeedStockPK id);
}
