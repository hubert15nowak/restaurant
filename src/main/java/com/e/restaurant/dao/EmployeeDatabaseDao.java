package com.e.restaurant.dao;

import com.e.restaurant.database.entity.Employee;
import com.e.restaurant.database.repository.EmployeeRepository;
import com.e.restaurant.dto.employee.EmployeeDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("employeeMysql")
public class EmployeeDatabaseDao implements EmployeeDao {

    private EmployeeRepository repository;

    @Autowired
    public EmployeeDatabaseDao(EmployeeRepository repository) {
        this.repository = repository;
    }


    @Override
    public void addEmployee(Employee employee) {
        repository.save(employee);
    }

    @Override
    public Iterable<Employee> getEmployees() {
        return repository.findAll();
    }
}
