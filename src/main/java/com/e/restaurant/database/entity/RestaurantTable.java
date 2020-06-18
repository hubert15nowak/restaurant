package com.e.restaurant.database.entity;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;
import org.springframework.lang.NonNull;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Entity
public class RestaurantTable {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Type(type = "uuid-char")
    @Column(length = 36, unique = true)
    private UUID id;

    @Column(nullable = false)
    private int seats;

    @Column(nullable = false, length = 45)
    private String name;

    @ManyToOne(optional = false)
    private Restaurant restaurant;

    @ManyToMany(mappedBy = "restaurantTables")
    private Set<Reservation> reservations = new HashSet<>();

    public RestaurantTable(@NonNull String name, @NonNull int seats, Restaurant restaurant) {
        this.name = name;
        this.seats = seats;
        this.restaurant = restaurant;
    }

    public RestaurantTable() {
    }


    public UUID getId() {
        return id;
    }

    public int getSeats() {
        return seats;
    }

    public String getName() {
        return name;
    }

    public Restaurant getRestaurant() {
        return restaurant;
        //w dto restaurant DTO a nie zwykle
    }

    public void setSeats(int seats) {
        this.seats = seats;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    public void setReservations(Set<Reservation> reservations) {
        this.reservations = reservations;
    }

    public Set<Reservation> getReservations() {
        return reservations;
    }
}
