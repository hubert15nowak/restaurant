package com.e.restaurant.dao;

import com.e.restaurant.database.repository.BillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("employeeMysql")
public class EmployeeDatabaseDao implements EmployeeDao {

    private BillRepository repository;

    @Autowired
    public EmployeeDatabaseDao(BillRepository repository) {
        this.repository = repository;
    }
}
