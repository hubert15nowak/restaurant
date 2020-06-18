package com.e.restaurant.service;


import com.e.restaurant.dao.ReservationDao;
import com.e.restaurant.database.entity.Reservation;
import com.e.restaurant.dto.reservation.CreateReservationDto;
import com.e.restaurant.dto.reservation.ReservationDto;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class ReservationService {

    private final ReservationDao reservationDao;


    public ReservationService(@Qualifier("reservationMysql") ReservationDao reservationDao) {
        this.reservationDao = reservationDao;
    }


    public void createReservation(CreateReservationDto reservation) throws DataIntegrityViolationException {
        reservationDao.saveReservation(reservation.mapToDao());
    }

    public Iterable<ReservationDto> getReservations() {
        return StreamSupport.stream(reservationDao.getReservations().spliterator(), true)
                .map(ReservationDto::mapToDto)
                .collect(Collectors.toList());
    }

    protected Optional<Reservation> getReservation(UUID id) {
        return reservationDao.getReservation(id);
    }

    public ReservationDto getReservationDto(UUID id) {
        Optional<Reservation> optionalReservation = getReservation(id);
        return optionalReservation.map(ReservationDto::mapToDto).orElse(null);
    }
}