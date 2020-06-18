package com.e.restaurant.controller;

import com.e.restaurant.dto.reservation.CreateReservationDto;
import com.e.restaurant.dto.reservation.ReservationDto;
import com.e.restaurant.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Controller
@RequestMapping("/v1/reservation")
public class ReservationController {

    private ReservationService reservationService;

    @Autowired
    public ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @PostMapping
    public @ResponseBody
    ResponseEntity<CreateReservationDto> createReservation(@RequestBody CreateReservationDto reservationDto) {
        try {
            reservationService.createReservation(reservationDto);
        } catch (DataIntegrityViolationException e) {
            return new ResponseEntity<CreateReservationDto>(reservationDto, HttpStatus.CONFLICT);
        }
        return new ResponseEntity<CreateReservationDto>(reservationDto, HttpStatus.CREATED);
    }

    @GetMapping
    public @ResponseBody
    Iterable<ReservationDto> getReservations() {
        return reservationService.getReservations();
    }

    @GetMapping("/{id}")
    public @ResponseBody
    ResponseEntity<ReservationDto> getReservation(@PathVariable UUID id) {
        ReservationDto reservationDto = reservationService.getReservationDto(id);
        if (reservationDto != null) {
            return new ResponseEntity<ReservationDto>(reservationDto, HttpStatus.OK);
        } else {
            return new ResponseEntity<ReservationDto>(HttpStatus.NOT_FOUND);
        }
    }
}