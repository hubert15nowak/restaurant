package com.e.restaurant.database.entity;

import com.e.restaurant.database.enumerate.UserRole;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.Set;
import java.util.UUID;

@Entity
public class Employee {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Type(type = "uuid-char")
    @Column(length = 36, unique = true)
    private UUID id;

    @OneToOne(optional = false)
    private User user;

    @Column(length = 45)
    private String name;

    @Column(length = 45)
    private String surname;

    @ManyToOne(optional = false)
    private Restaurant restaurant;

    @ManyToMany(mappedBy = "employees")
    private Set<Bill> bills;

    public Employee(UUID id, String name, String surname, User user) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.user = user;
    }

    public Employee() {

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
        return user.getUsername();
    }

    public String getPassword() {
        return user.getPassword();
    }

    public UserRole getRole() {
        return getUser().getRole();
    }
}
