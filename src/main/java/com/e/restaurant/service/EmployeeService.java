package com.e.restaurant.service;

import com.e.restaurant.dao.EmployeeDao;
import com.e.restaurant.database.entity.Employee;
import com.e.restaurant.database.entity.Restaurant;
import com.e.restaurant.database.entity.User;
import com.e.restaurant.dto.employee.CreateEmployeeDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class EmployeeService {

    private EmployeeDao employeeDao;
    private UserService userService;
    private RestaurantService restaurantService;

    @Autowired
    public EmployeeService(@Qualifier("employeeMysql") EmployeeDao employeeDao, UserService userService, RestaurantService restaurantService) {
        this.employeeDao = employeeDao;
        this.userService = userService;
        this.restaurantService = restaurantService;
    }

    @Transactional
    protected void createEmployee(Employee employee) throws DataIntegrityViolationException {
        Optional<User> optionalUser = userService.getUser(employee.getUser().getLogin());
        if (optionalUser.isEmpty()) {
            Optional<Restaurant> optionalRestaurant = restaurantService.getRestaurant(employee.getRestaurant().getName());
            if (optionalRestaurant.isPresent()) {
                userService.addUser(employee.getUser());
                employee.setRestaurant(optionalRestaurant.get());
                employeeDao.addEmployee(employee);
                return;
            } else {
                throw new DataIntegrityViolationException("restaurant does not exists");
            }
        }
        throw new DataIntegrityViolationException("login is used");
    }

    public void createEmployeeFromDto(CreateEmployeeDto createEmployeeDto) throws DataIntegrityViolationException {
        createEmployee(createEmployeeDto.mapToEmployee());
    }
}
