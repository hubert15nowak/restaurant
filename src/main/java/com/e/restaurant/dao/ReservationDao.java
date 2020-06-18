package com.e.restaurant.dao;

import com.e.restaurant.database.entity.Reservation;

import java.util.Optional;
import java.util.UUID;

public interface ReservationDao {
    void saveReservation(Reservation reservation);

    Iterable<Reservation> getReservations();

    Optional<Reservation> getReservation(UUID id);
}
