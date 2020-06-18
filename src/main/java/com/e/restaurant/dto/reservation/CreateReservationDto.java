package com.e.restaurant.dto.reservation;

import com.e.restaurant.database.entity.Employee;
import com.e.restaurant.database.entity.Reservation;
import com.e.restaurant.database.entity.RestaurantTable;

import java.util.Date;
import java.util.Set;
import java.util.UUID;

public class CreateReservationDto {
    public UUID id;
    public Date date;
    public String name;
    public String phoneNumber;
    public Employee employee;
    public Set<RestaurantTable> restaurantTables;


    public Reservation mapToDao() {
        return new Reservation(name, date, phoneNumber, employee, restaurantTables);
    }

}
