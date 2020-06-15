package com.e.restaurant.database.entity;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity
public class BillDish {

    @EmbeddedId
    private BillDishPK pk;

    @Column(nullable = false)
    private int quantity;

    public Bill getBill() {
        return pk.getBill();
    }

    public Dish getDish() {
        return pk.getDish();
    }
}
