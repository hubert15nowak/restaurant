package com.e.restaurant.service;


import com.e.restaurant.dao.RestaurantTableDao;
import com.e.restaurant.database.entity.RestaurantTable;
import com.e.restaurant.dto.restaurantTable.CreateRestaurantTableDto;
import com.e.restaurant.dto.restaurantTable.RestaurantTableDto;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class RestaurantTableService {

    private final RestaurantTableDao restaurantTableDao;


    public RestaurantTableService(@Qualifier("restaurantTableMysql") RestaurantTableDao restaurantTableDao) {
        this.restaurantTableDao = restaurantTableDao;
    }


    public void createRestaurantTable(CreateRestaurantTableDto restaurantTable) throws DataIntegrityViolationException {
        restaurantTableDao.saveRestaurantTable(restaurantTable.mapToDao());
    }

    public Iterable<RestaurantTableDto> getRestaurantTables() {
        return StreamSupport.stream(restaurantTableDao.getRestaurantTables().spliterator(), true)
                .map(RestaurantTableDto::mapToDto)
                .collect(Collectors.toList());
    }

    protected Optional<RestaurantTable> getRestaurantTable(UUID id) {
        return restaurantTableDao.getRestaurantTable(id);
    }

    public RestaurantTableDto getRestaurantTableDto(UUID id) {
        Optional<RestaurantTable> optionalRestaurantTable = getRestaurantTable(id);
        return optionalRestaurantTable.map(RestaurantTableDto::mapToDto).orElse(null);
    }
}