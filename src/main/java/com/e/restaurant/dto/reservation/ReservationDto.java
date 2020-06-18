package com.e.restaurant.dto.reservation;


import com.e.restaurant.database.entity.Reservation;
import com.e.restaurant.dto.employee.EmployeeDto;
import com.e.restaurant.dto.restaurantTable.RestaurantTableDto;

import java.util.Date;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

public class ReservationDto {

    public UUID id;
    public Date date;
    public String name;
    public String phoneNumber;
    public EmployeeDto employee;
    public Set<RestaurantTableDto> restaurantTables;


    public static ReservationDto mapToDto(Reservation reservation) {
        return new ReservationDto(
                reservation.getId(),
                reservation.getName(),
                reservation.getDate(),
                reservation.getPhoneNumber(),
                EmployeeDto.mapToDto(reservation.getEmployee()),
                reservation.getRestaurantTables().stream().map(RestaurantTableDto::mapToDto).collect(Collectors.toSet()));
    }


    public ReservationDto(UUID id, String name, Date date, String phoneNumber, EmployeeDto employee, Set<RestaurantTableDto> restaurantTables) {
        this.id = id;
        this.name = name;
        this.date = date;
        this.phoneNumber = phoneNumber;
        this.employee = employee;
        this.restaurantTables = restaurantTables;
    }

    public Reservation mapToDao() {
        Reservation reservation = new Reservation(id, name, date, phoneNumber, employee.mapToDao(),
                null); //TODO: change null to sth else
        return reservation;
    }


}
