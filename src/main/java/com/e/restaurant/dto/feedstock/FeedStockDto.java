package com.e.restaurant.dto.feedstock;

import com.e.restaurant.database.entity.FeedStock;

public class FeedStockDto {

    public FeedStockPKDto id;

    public FeedStockDto(FeedStockPKDto id) {
        this.id = id;
    }

    public FeedStockDto() {
    }


    public static FeedStockDto mapToDto(FeedStock feedStock) {
        return new FeedStockDto(FeedStockPKDto.mapToDto(feedStock.getId()));
    }

    public FeedStock mapToDao() {
        FeedStock feedStock = new FeedStock();
        feedStock.setId(id.mapToDao());
        return feedStock;
    }
}
