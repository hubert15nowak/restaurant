package com.e.restaurant.dto.dishType;

import com.e.restaurant.database.entity.Dish;
import com.e.restaurant.database.entity.DishType;

import java.util.Set;

public class DishTypeDto {

    public String name;
    public Set<Dish> dishSet;

    public DishTypeDto(String name) {
        this.name = name;
    }

    public static DishTypeDto mapToDto(DishType dishType) {
        return new DishTypeDto(dishType.getName());
    }
}
