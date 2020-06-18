package com.e.restaurant.service;

import com.e.restaurant.dao.FeedStockDao;
import com.e.restaurant.database.entity.FeedStock;
import com.e.restaurant.database.entity.FeedStock.FeedStockPK;
import com.e.restaurant.database.entity.Restaurant;
import com.e.restaurant.dto.feedstock.CreateFeedStockDto;
import com.e.restaurant.dto.feedstock.FeedStockDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class FeedStockService {

    private FeedStockDao feedStockDao;
    private RestaurantService restaurantService;

    @Autowired
    public FeedStockService(@Qualifier("feedStockMysql") FeedStockDao feedStockDao, RestaurantService restaurantService) {
        this.feedStockDao = feedStockDao;
        this.restaurantService = restaurantService;
    }

    protected Optional<FeedStock> getFeedstockById(FeedStockPK feedStockPK) throws DataIntegrityViolationException {
        return feedStockDao.getById(feedStockPK);
    }


    protected void createFeedStock(FeedStock feedStock) throws DataIntegrityViolationException {
        feedStockDao.add(feedStock);
    }

    @Transactional
    protected void createFeedStock(FeedStockPK feedStockPK) throws DataIntegrityViolationException {
        Optional<Restaurant> optionalRestaurant = restaurantService.getRestaurant(feedStockPK.getRestaurant().getName());
        if (optionalRestaurant.isPresent()) {
            feedStockPK.setRestaurant(optionalRestaurant.get());
            Optional<FeedStock> feedstockById = getFeedstockById(feedStockPK);
            if (feedstockById.isEmpty()) {
                FeedStock feedStock = new FeedStock(feedStockPK);
                createFeedStock(feedStock);
                return;
            } else {
                throw new DataIntegrityViolationException("restaurant does not exists");
            }
        }
        throw new DataIntegrityViolationException("feedstock exist");
    }

    public void createFeedStock(CreateFeedStockDto feedStockDto) throws DataIntegrityViolationException {
        createFeedStock(feedStockDto.mapToFeedStockPK().mapToDao());
    }

    protected Iterable<FeedStock> getFeedStocks(){
        return feedStockDao.getAll();
    }

    public Iterable<FeedStockDto> getFeedStockDtos() {
        return StreamSupport.stream(getFeedStocks().spliterator(), true)
                .map(FeedStockDto::mapToDto).collect(Collectors.toList());
    }
}
