package com.e.restaurant.service;

import com.e.restaurant.dao.DishTypeDao;
import com.e.restaurant.database.entity.DishType;
import com.e.restaurant.dto.dishType.CreateDishTypeDto;
import com.e.restaurant.dto.dishType.DishTypeDto;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class DishTypeService {

    private final DishTypeDao dishTypeDao;


    public DishTypeService(@Qualifier("dishTypeMysql") DishTypeDao dishTypeDao) {
        this.dishTypeDao = dishTypeDao;
    }


    public void createDishType(CreateDishTypeDto dishType) throws DataIntegrityViolationException {
        addUser(dishType.mapToDao());
    }

    public Iterable<DishTypeDto> getDishTypes() {
        return StreamSupport.stream(dishTypeDao.getDishTypes().spliterator(), true)
                .map(DishTypeDto::mapToDto)
                .collect(Collectors.toList());
    }

    protected void addUser(DishType dishType) throws DataIntegrityViolationException {
        dishTypeDao.saveDishType(dishType);
    }

    protected Optional<DishType> getDishType(String name) {
        return dishTypeDao.getDishType(name);
    }

    public DishTypeDto getDishTypeDto(String name) {
        Optional<DishType> optionalDishType = getDishType(name);
        return optionalDishType.map(DishTypeDto::mapToDto).orElse(null);
    }
}