package com.e.restaurant.database.repository;

import com.e.restaurant.database.entity.FeedStock;
import com.e.restaurant.database.entity.FeedstockPK;
import org.springframework.data.repository.CrudRepository;

public interface FeedStockRepository extends CrudRepository<FeedStock, FeedstockPK> {
}
