package com.e.restaurant.database.entity;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.*;

@Entity
public class Reservation {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Type(type = "uuid-char")
    @Column(length = 36, unique = true)
    private UUID id;

    @Column(nullable = false)
    private Date date;

    @Column(length = 45, nullable = false)
    private String name;

    @Column(length = 11)
    private String phoneNumber;

    @ManyToOne
    private Employee employee;

    @ManyToMany
    @JoinTable(name = "Table_Reservation")
    private Set<RestaurantTable> restaurantTables = new HashSet<>(); //change


}
