package com.e.restaurant.dao;

import com.e.restaurant.database.entity.Reservation;
import com.e.restaurant.database.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository("reservationMysql")
public class ReservationDatabaseDao implements ReservationDao {

    private ReservationRepository repository;

    @Autowired
    public ReservationDatabaseDao(ReservationRepository repository) {
        this.repository = repository;
    }

    @Override
    public void saveReservation(Reservation reservation) {
        repository.save(reservation);
    }

    @Override
    public Iterable<Reservation> getReservations() {
        return repository.findAll();
    }

    @Override
    public Optional<Reservation> getReservation(UUID id) {
        return repository.findById(id);
    }
}
