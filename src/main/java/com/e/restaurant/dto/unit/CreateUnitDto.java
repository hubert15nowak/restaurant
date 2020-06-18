package com.e.restaurant.dto.unit;

import com.e.restaurant.database.entity.Unit;

public class CreateUnitDto {

    public String name;

    public Unit mapToDao() {
        Unit unit = new Unit();
        unit.setName(name);
        return unit;
    }
}
