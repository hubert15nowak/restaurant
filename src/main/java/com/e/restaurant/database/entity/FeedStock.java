package com.e.restaurant.database.entity;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity
public class FeedStock {

    @EmbeddedId
    private FeedstockPK id;


    public String getName() {
        return id.getName();
    }

    public double getPrice() {
        return id.getPrice();
    }

    public Restaurant getRestaurant() {
        return id.getRestaurant();
    }
}
