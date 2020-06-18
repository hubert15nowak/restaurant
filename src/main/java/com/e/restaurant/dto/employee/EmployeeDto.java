package com.e.restaurant.dto.employee;

import com.e.restaurant.database.entity.Employee;
import com.e.restaurant.dto.user.UserDto;

import java.util.UUID;

public class EmployeeDto {

    public UUID id;
    public String name;
    public String surname;
    public UserDto userDto;

    public static EmployeeDto mapToDto(Employee employee) {
        EmployeeDto employeeDto = new EmployeeDto();
        UserDto userDto = new UserDto(employee.getLogin(), employee.getPassword(), employee.getRole());
        employeeDto.userDto = userDto;
        employeeDto.id = employee.getId();
        employeeDto.name = employee.getName();
        employeeDto.surname = employee.getSurname();
        return employeeDto;
    }

    public Employee mapToDao() {
        return new Employee(id, name, surname, userDto.mapToDao());
    }

}
