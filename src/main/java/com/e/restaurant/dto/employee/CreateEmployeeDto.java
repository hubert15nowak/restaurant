package com.e.restaurant.dto.employee;

import com.e.restaurant.database.entity.Employee;
import com.e.restaurant.database.entity.Restaurant;
import com.e.restaurant.database.entity.User;
import com.e.restaurant.database.enumerate.UserRole;
import com.e.restaurant.security.PasswordConfig;

public class CreateEmployeeDto {

    public String username;
    public String password;
    public UserRole role;
    public String name;
    public String surname;
    public String restaurant;

    public Employee mapToEmployee() {
        User user = new User();
        user.setUsername(username);
        user.setPassword(PasswordConfig.hashPassword(password));
        user.setRole(role);
        Employee employee = new Employee();
        employee.setName(name);
        employee.setSurname(surname);
        employee.setUser(user);
        employee.setRestaurant(new Restaurant(restaurant));
        return employee;
    }


}
