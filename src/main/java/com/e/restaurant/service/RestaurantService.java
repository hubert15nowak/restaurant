package com.e.restaurant.service;

import com.e.restaurant.dao.RestaurantDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class RestaurantService {

    private final RestaurantDao restaurantDao;


    public RestaurantService(@Qualifier("restaurantMysql") RestaurantDao restaurantDao) {
        this.restaurantDao = restaurantDao;
    }



}
