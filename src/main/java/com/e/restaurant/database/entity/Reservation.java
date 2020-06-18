package com.e.restaurant.database.entity;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;
import org.springframework.lang.NonNull;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

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
    private Set<RestaurantTable> restaurantTables = new HashSet<>();

    public Reservation() {
    }


    public Reservation(@NonNull String name, @NonNull Date date, String phoneNumber, Employee employee, Set<RestaurantTable> restaurantTables) {
        this.name = name;
        this.date = date;
        this.phoneNumber = phoneNumber;
        this.employee = employee;
        this.restaurantTables = restaurantTables;
    }

    public Reservation(UUID id, @NonNull String name, @NonNull Date date, String phoneNumber, Employee employee, Set<RestaurantTable> restaurantTables) {
        this.id = id;
        this.name = name;
        this.date = date;
        this.phoneNumber = phoneNumber;
        this.employee = employee;
        this.restaurantTables = restaurantTables;
    }


    public UUID getId() {
        return id;
    }

    public Date getDate() {
        return date;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public Employee getEmployee() {
        return employee;
    }

    public Set<RestaurantTable> getRestaurantTables() {
        return restaurantTables;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public void setRestaurantTables(Set<RestaurantTable> restaurantTables) {
        this.restaurantTables = restaurantTables;
    }
}
