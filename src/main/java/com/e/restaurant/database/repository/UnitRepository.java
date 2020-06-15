package com.e.restaurant.database.repository;

import com.e.restaurant.database.entity.Unit;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface UnitRepository extends CrudRepository<Unit, UUID> {
}