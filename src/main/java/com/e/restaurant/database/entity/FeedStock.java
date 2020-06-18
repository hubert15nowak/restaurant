package com.e.restaurant.database.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class FeedStock {

    @EmbeddedId
    private FeedStockPK id;


    @OneToOne
    private Storeroom storeroom;

    public FeedStock() {
    }

    public FeedStock(FeedStockPK feedStock) {
        this.id = feedStock;
    }


    public String getName() {
        return id.getName();
    }

    public double getPrice() {
        return id.getPrice();
    }

    public Restaurant getRestaurant() {
        return id.getRestaurant();
    }




    @Embeddable
    public static class FeedStockPK implements Serializable {

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

            FeedStockPK that = (FeedStockPK) o;

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

        public void setName(String name) {
            this.name = name;
        }

        public void setPrice(double price) {
            this.price = price;
        }

        public void setRestaurant(Restaurant restaurant) {
            this.restaurant = restaurant;
        }
    }

    public FeedStockPK getId() {
        return id;
    }

    public Storeroom getStoreroom() {
        return storeroom;
    }

    public void setId(FeedStockPK id) {
        this.id = id;
    }

    public void setStoreroom(Storeroom storeroom) {
        this.storeroom = storeroom;
    }
}
