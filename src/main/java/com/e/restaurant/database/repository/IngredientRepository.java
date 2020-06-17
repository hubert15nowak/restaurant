package com.e.restaurant.database.repository;

import com.e.restaurant.database.entity.Ingredient;
import org.springframework.data.repository.CrudRepository;

public interface IngredientRepository extends CrudRepository<Ingredient, Ingredient.IngredientPK> {
}
