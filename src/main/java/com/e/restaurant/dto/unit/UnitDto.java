package com.e.restaurant.dto.unit;

import com.e.restaurant.database.entity.Unit;

import java.util.UUID;

public class UnitDto {

    public String name;
    public UUID id;

    public UnitDto(UUID id, String name) {
        this.id = id;
        this.name = name;
    }

    public static UnitDto mapToDto(Unit unit) {
        return new UnitDto(unit.getId(), unit.getName());
    }
}
