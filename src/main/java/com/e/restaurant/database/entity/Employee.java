package com.e.restaurant.database.entity;

import com.e.restaurant.database.enumerate.EmployeeType;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;
import java.util.UUID;

@Entity
public class Employee {

    @EmbeddedId
    private EmployeeId id;

    @MapsId("id")
    @OneToOne
    private User user;

    @Column(length = 45)
    private String name;

    @Column(length = 45)
    private String surname;

    @ManyToOne(optional = false)
    private Restaurant restaurant;

    @ManyToMany(mappedBy = "employees")
    private Set<Bill> bills;

    @Embeddable
    public static class EmployeeId implements Serializable {
        UUID id;
    }

    public void setId(EmployeeId id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    public Set<Bill> getBills() {
        return bills;
    }

    public void setBills(Set<Bill> bills) {
        this.bills = bills;
    }

    public UUID getId() {
        return user.getId();
    }

    public String getLogin() {
        return user.getLogin();
    }

    public String getPassword() {
        return user.getPassword();
    }
}
