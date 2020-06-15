package com.e.restaurant.database.repository;

import com.e.restaurant.database.entity.Ingredient;
import com.e.restaurant.database.entity.IngredientPK;
import org.springframework.data.repository.CrudRepository;

public interface IngredientRepository extends CrudRepository<Ingredient, IngredientPK> {
}
