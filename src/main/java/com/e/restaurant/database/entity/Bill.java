package com.e.restaurant.database.entity;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;
import java.util.UUID;

@Entity
public class Bill {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Type(type = "uuid-char")
    @Column(length = 36, unique = true)
    private UUID id;

    @Column(columnDefinition = "DATETIME", nullable = false)
    private Date date;

    @Column(columnDefinition = "Decimal(7,2)", nullable = false)
    private double price;

    @Column( nullable = false)
    private boolean take_away;

    @ManyToOne(optional = false)
    private Restaurant restaurant;

    @ManyToMany
    private Set<Discount> discountApplied;

    @ManyToMany
    private Set<Employee> employees;
}
