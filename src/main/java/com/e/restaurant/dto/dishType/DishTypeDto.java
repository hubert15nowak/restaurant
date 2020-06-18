package com.e.restaurant.dto.dishType;

import com.e.restaurant.database.entity.Dish;
import com.e.restaurant.database.entity.DishType;

import java.util.Set;
import java.util.UUID;

public class DishTypeDto {

    public UUID id;
    public String name;
    public Set<Dish> dishSet;


    public DishTypeDto(UUID id, String name) {
        this.id = id;
        this.name = name;
    }

    public DishTypeDto(UUID id) {
        this.id = id;
    }

    public static DishTypeDto mapToDto(DishType dishType) {
        return new DishTypeDto(dishType.getId(), dishType.getName());
    }

    public DishType mapToDao() {
        return new DishType(id);
    }
}
