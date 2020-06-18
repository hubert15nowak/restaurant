package com.e.restaurant.dto.feedstock;

import com.e.restaurant.dto.restaurant.RestaurantDto;

public class CreateFeedStockDto {

    public String name;
    public double price;
    public String restaurant;

    public FeedStockPKDto mapToFeedStockPK() {
        FeedStockPKDto feedStockPKDto = new FeedStockPKDto();
        feedStockPKDto.name = name;
        feedStockPKDto.price = price;
        feedStockPKDto.restaurant = new RestaurantDto(null, restaurant);
        return feedStockPKDto;
    }
}
