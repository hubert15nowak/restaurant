package com.e.restaurant.database.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Embeddable
public class FeedstockPK implements Serializable {

    @Column(length = 45)
    protected String name;
    @Column(columnDefinition = "Decimal(7,2)")
    protected double price;
    @ManyToOne(optional = false)
    private Restaurant restaurant;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FeedstockPK that = (FeedstockPK) o;

        if (Double.compare(that.price, price) != 0) return false;
        if (!name.equals(that.name)) return false;
        return restaurant.equals(that.restaurant);
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = name.hashCode();
        temp = Double.doubleToLongBits(price);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + restaurant.hashCode();
        return result;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }
}
