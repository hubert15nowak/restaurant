package com.e.restaurant.dao;

import com.e.restaurant.database.entity.DishType;
import com.e.restaurant.database.repository.DishTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository("dishTypeMysql")
public class DishTypeDatabaseDao implements DishTypeDao {

    private DishTypeRepository repository;

    @Autowired
    public DishTypeDatabaseDao(DishTypeRepository repository) {
        this.repository = repository;
    }

    @Override
    public void saveDishType(DishType dishType) {
        repository.save(dishType);
    }

    @Override
    public Optional<DishType> getDishType(String name) {
        return repository.findFirstByName(name);
    }

    @Override
    public Iterable<DishType> getDishTypes() {
        return repository.findAll();
    }
}
