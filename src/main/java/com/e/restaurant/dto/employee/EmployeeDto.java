package com.e.restaurant.dto.employee;

import com.e.restaurant.database.entity.Employee;
import com.e.restaurant.database.enumerate.UserRole;

import java.util.UUID;

public class EmployeeDto {

    public UUID id;
    public String login;
    public UserRole role;
    public String name;
    public String surname;
    public String restaurant;

    public static EmployeeDto mapToDto(Employee employee) {
        EmployeeDto employeeDto = new EmployeeDto();
        employeeDto.id = employee.getId();
        employeeDto.login = employee.getLogin();
        employeeDto.name = employee.getName();
        employeeDto.surname = employee.getSurname();
        employeeDto.restaurant = employee.getRestaurant().getName();
        employeeDto.role = employee.getRole();
        return employeeDto;
    }
}
