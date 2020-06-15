package com.e.restaurant.database.entity;

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

    @Column(length = 45, nullable = false, unique = true)
    private String login;

    @Column(length = 60, nullable = false)
    private String password;

    @Column(length = 45)
    private String name;

    @Column(length = 45)
    private String surname;

    @ManyToOne(optional = false)
    private Restaurant restaurant;

    @ManyToMany(mappedBy = "employees")
    private Set<Bill> bills;
}
