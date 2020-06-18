package com.e.restaurant.dto.dishType;

import com.e.restaurant.database.entity.DishType;

import java.util.UUID;

public class DishTypeGroupDto {

    public UUID id;
    public String name;

    public DishTypeGroupDto(UUID id, String name) {
        this.id = id;
        this.name = name;
    }

    public DishTypeGroupDto(UUID id) {
        this.id = id;
    }

    public static DishTypeGroupDto mapToDto(DishType dishType) {
        return new DishTypeGroupDto(dishType.getId(), dishType.getName());
    }

    public DishType mapToDao() {
        return new DishType(id);
    }
}
