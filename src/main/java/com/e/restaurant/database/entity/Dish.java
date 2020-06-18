package com.e.restaurant.database.entity;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.Set;
import java.util.UUID;

@Entity
public class Dish {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Type(type = "uuid-char")
    @Column(length = 36, unique = true)
    private UUID id;

    @Column(length = 45, nullable = false)
    private String name;

    @Column(columnDefinition = "Decimal(7,2)", nullable = false)
    private double price;

    @Column(nullable = false)
    private boolean inMenu;

    @ManyToOne(optional = false)
    private Restaurant restaurant;

    @ManyToMany(mappedBy = "dishSet")
    private Set<DishType> dishType;

    public Dish() {
    }

    public Dish(String name, double price, boolean inMenu, Restaurant restaurant, Set<DishType> dishType) {
        this.name = name;
        this.price = price;
        this.inMenu = inMenu;
        this.restaurant = restaurant;
        this.dishType = dishType;
    }

    public Dish(UUID id, String name, double price, boolean inMenu, Restaurant restaurant, Set<DishType> dishType) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.inMenu = inMenu;
        this.restaurant = restaurant;
        this.dishType = dishType;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public boolean isInMenu() {
        return inMenu;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public Set<DishType> getDishType() {
        return dishType;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setInMenu(boolean inMenu) {
        this.inMenu = inMenu;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    public void setDishType(Set<DishType> dishType) {
        this.dishType = dishType;
    }
}
