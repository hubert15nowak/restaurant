package com.e.restaurant.database.entity;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.Set;
import java.util.UUID;

@Entity
public class DishType {
    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Type(type = "uuid-char")
    @Column(length = 36, unique = true)
    private UUID id;

    @Column(length = 45, nullable = false, unique = true)
    String name;

    public DishType() {
    }

    public DishType(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public UUID getId() {
        return id;
    }

    @ManyToMany
    private Set<Dish> dishSet;
}
