package com.e.restaurant.database.entity;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.UUID;

@Entity
public class Storeroom {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Type(type = "uuid-char")
    @Column(length = 36, unique = true)
    private UUID id;

    private double quantity;

    @OneToOne(mappedBy = "storeroom")
    private FeedStock feedStock;

    @ManyToOne(optional = false)
    private Unit unit;


    //Getters

    public String getName() {
        return feedStock.getName();
    }

    public double getPrice() {
        return feedStock.getPrice();
    }

    public Restaurant getRestaurant() {
        return feedStock.getRestaurant();
    }
}
