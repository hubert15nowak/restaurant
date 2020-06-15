package com.e.restaurant.database.entity;

import com.e.restaurant.database.enumerate.DiscountType;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@Entity
public class Discount {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Type(type = "uuid-char")
    @Column(length = 36, unique = true)
    private UUID id;

    @ManyToOne
    private Dish dish;

    @ManyToOne
    private DishType dishType;

    @Column
    private double minimumPrice;

    @Column(columnDefinition = "Decimal(6,2)", nullable = false)
    private double discount;

    @Column(nullable = false)
    private DiscountType type;

    @Column(columnDefinition = "DATETIME", nullable = false)
    private Date startDate;

    @Column(columnDefinition = "DATETIME", nullable = false)
    private Date endDate;

    @ManyToOne(optional = false)
    private Restaurant restaurant;
}
