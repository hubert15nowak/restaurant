package com.e.restaurant.database.repository;

import com.e.restaurant.database.entity.Unit;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;
import java.util.UUID;

public interface UnitRepository extends CrudRepository<Unit, UUID> {
    Optional<Unit> findUnitByName(String name);

    Optional<Unit> findFirstByName(String name);
}