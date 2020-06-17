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

    public UUID getId() {
        return user.getId();
    }

    public String getLogin() {
        return user.getLogin();
    }

    public String getPassword() {
        return user.getPassword();
    }

    @Embeddable
    public static class EmployeeId implements Serializable {
        UUID id;
    }
}
