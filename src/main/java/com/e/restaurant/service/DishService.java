package com.e.restaurant.service;

import com.e.restaurant.dao.DishDao;
import com.e.restaurant.database.entity.Dish;
import com.e.restaurant.dto.dish.CreateDishDto;
import com.e.restaurant.dto.dish.DishDto;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class DishService {
    private final DishDao dishDao;

    public DishService(@Qualifier("dishMysql") DishDao dishDao) {
        this.dishDao = dishDao;
    }


    public void createDish(CreateDishDto dish) throws DataIntegrityViolationException {
        addDish(dish.mapToDao());
    }

    public Iterable<DishDto> getDishes() {
        return StreamSupport.stream(dishDao.getDishes().spliterator(), true)
                .map(DishDto::mapToDto)
                .collect(Collectors.toList());
    }

    protected void addDish(Dish dish) throws DataIntegrityViolationException {
        dishDao.saveDish(dish);
    }

    protected Optional<Dish> getDish(UUID id) {
        return dishDao.getDish(id);
    }

    public DishDto getDishDto(UUID id) {
        Optional<Dish> optionalDish = getDish(id);
        return optionalDish.map(DishDto::mapToDto).orElse(null);
    }
}