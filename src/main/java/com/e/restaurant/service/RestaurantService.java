package com.e.restaurant.service;

import com.e.restaurant.dao.RestaurantDao;
import com.e.restaurant.dto.restaurant.CreateRestaurantDto;
import com.e.restaurant.dto.restaurant.RestaurantDto;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class RestaurantService {

    private final RestaurantDao restaurantDao;


    public RestaurantService(@Qualifier("restaurantMysql") RestaurantDao restaurantDao) {
        this.restaurantDao = restaurantDao;
    }


    public void createRestaurant(CreateRestaurantDto restaurant) throws DataIntegrityViolationException {
        restaurantDao.saveRestaurant(restaurant.mapToDao());
    }

    public Iterable<RestaurantDto> getRestaurants() {
        return StreamSupport.stream(restaurantDao.getRestaurants().spliterator(), true)
                .map(RestaurantDto::mapToDto)
                .collect(Collectors.toList());
    }
}
