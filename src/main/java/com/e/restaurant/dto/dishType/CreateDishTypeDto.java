package com.e.restaurant.dto.dishType;

import com.e.restaurant.database.entity.DishType;

public class CreateDishTypeDto {
    public String name;

    public DishType mapToDao() {
        DishType dishType = new DishType();
        dishType.setName(name);
        return dishType;
    }
}
