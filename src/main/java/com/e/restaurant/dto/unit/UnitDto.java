package com.e.restaurant.dto.unit;

import com.e.restaurant.database.entity.Unit;

public class UnitDto {

    public String name;

    public UnitDto(String name) {
        this.name = name;
    }

    public static UnitDto mapToDto(Unit unit) {
        return new UnitDto(unit.getName());
    }
}
