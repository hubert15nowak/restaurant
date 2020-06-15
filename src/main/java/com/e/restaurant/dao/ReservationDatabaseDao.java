package com.e.restaurant.dao;

import com.e.restaurant.database.repository.BillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("reservationMysql")
public class ReservationDatabaseDao implements ReservationDao {

    private BillRepository repository;

    @Autowired
    public ReservationDatabaseDao(BillRepository repository) {
        this.repository = repository;
    }
}
