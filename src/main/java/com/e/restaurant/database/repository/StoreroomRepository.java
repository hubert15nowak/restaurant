package com.e.restaurant.database.repository;

import com.e.restaurant.database.entity.Storeroom;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface StoreroomRepository extends CrudRepository<Storeroom, UUID> {
}