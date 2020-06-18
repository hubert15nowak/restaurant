package com.e.restaurant.dto.feedstock;

import com.e.restaurant.database.entity.FeedStock;
import com.e.restaurant.dto.restaurant.RestaurantDto;

public class FeedStockPKDto {

    public String name;
    public double price;
    public RestaurantDto restaurant;

    public FeedStockPKDto(FeedStock.FeedStockPK feedStockPK) {
        name = feedStockPK.getName();
        price = feedStockPK.getPrice();
        restaurant = RestaurantDto.mapToDto(feedStockPK.getRestaurant());
    }

    public FeedStockPKDto() {

    }

    public FeedStock.FeedStockPK mapToDao() {
        FeedStock.FeedStockPK feedStockPK = new FeedStock.FeedStockPK();
        feedStockPK.setRestaurant(restaurant.mapToDao());
        feedStockPK.setName(name);
        feedStockPK.setPrice(price);
        return feedStockPK;
    }

    public static FeedStockPKDto mapToDto(FeedStock.FeedStockPK feedStockPK) {
        return new FeedStockPKDto(feedStockPK);
    }
}
