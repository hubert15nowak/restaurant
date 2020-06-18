package com.e.restaurant.dto.dishType;

import com.e.restaurant.database.entity.DishType;
import com.e.restaurant.dto.dish.DishGroupDto;

import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

public class DishTypeDto {

    public UUID id;
    public String name;
    public Set<DishGroupDto> dishSet;


    public DishTypeDto(UUID id, String name) {
        this.id = id;
        this.name = name;
    }

    public DishTypeDto(UUID id) {
        this.id = id;
    }

    public DishTypeDto(UUID id, String name, Set<DishGroupDto> dishSet) {
        this.id = id;
        this.name = name;
        this.dishSet = dishSet;
    }

    public static DishTypeDto mapToDto(DishType dishType) {
        return new DishTypeDto(
                dishType.getId(),
                dishType.getName(),
                dishType.getDishSet().stream()
                        .map(DishGroupDto::mapToDto)
                        .collect(Collectors.toSet())
        );
    }

    public DishType mapToDao() {
        return new DishType(id);
    }
}
