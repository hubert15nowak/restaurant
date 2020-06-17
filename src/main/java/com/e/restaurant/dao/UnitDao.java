package com.e.restaurant.dao;

import com.e.restaurant.database.entity.Unit;

import java.util.Optional;

public interface UnitDao {
    void saveUnit(Unit unit);

    Optional<Unit> getUnit(String name);

    Iterable<Unit> getUnits();
}
