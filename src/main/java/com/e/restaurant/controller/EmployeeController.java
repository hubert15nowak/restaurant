package com.e.restaurant.controller;

import com.e.restaurant.dto.employee.CreateEmployeeDto;
import com.e.restaurant.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/v1/employee")
public class EmployeeController {

    private EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping
    public @ResponseBody ResponseEntity<CreateEmployeeDto> createRestaurant(@RequestBody CreateEmployeeDto createEmployeeDto) {
        try {
            employeeService.createEmployee(createEmployeeDto);
        } catch (DataIntegrityViolationException e) {
            return new ResponseEntity<>(createEmployeeDto, HttpStatus.CONFLICT);
        }
        return new ResponseEntity<>(createEmployeeDto, HttpStatus.CREATED);
    }
}
