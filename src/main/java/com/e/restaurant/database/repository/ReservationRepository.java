package com.e.restaurant.database.repository;

import com.e.restaurant.database.entity.Reservation;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface ReservationRepository extends CrudRepository<Reservation, UUID> {
}