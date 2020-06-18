package com.e.restaurant.database.repository;

import com.e.restaurant.database.entity.Employee;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface EmployeeRepository extends CrudRepository<Employee, UUID> {
    Iterable<Employee> findAll();
}