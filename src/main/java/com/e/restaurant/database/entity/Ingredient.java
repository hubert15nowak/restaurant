package com.e.restaurant.database.entity;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity
public class Ingredient {

    @EmbeddedId
    private IngredientPK pk;

    private double quantity;
}
