package com.e.restaurant.dao;

import com.e.restaurant.database.entity.Dish;
import com.e.restaurant.database.repository.DishRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository("dishMysql")
public class DishDatabaseDao implements DishDao {

    private DishRepository repository;

    @Autowired
    public DishDatabaseDao(DishRepository repository) {
        this.repository = repository;
    }

    @Override
    public void saveDish(Dish dish) {
        repository.save(dish);
    }

    @Override
    public Optional<Dish> getDish(UUID id) {
        return repository.findById(id);
    }

    @Override
    public Iterable<Dish> getDishes() {
        return repository.findAll();
    }
}
