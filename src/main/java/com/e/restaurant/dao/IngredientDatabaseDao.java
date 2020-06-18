package com.e.restaurant.dao;

import com.e.restaurant.database.repository.IngredientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository("ingredientMysql")
public class IngredientDatabaseDao implements IngredientDao {


    private IngredientRepository repository;

    @Autowired
    public IngredientDatabaseDao(IngredientRepository repository) {
        this.repository = repository;
    }
}
