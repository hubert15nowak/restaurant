package com.e.restaurant.database.entity;

import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Entity
public class Ingredient {

    @EmbeddedId
    private IngredientPK pk;

    private double quantity;

    @Embeddable
    public static class IngredientPK implements Serializable {

        @ManyToOne(optional = false)
        private Unit unit;

        @ManyToOne(optional = false)
        private FeedStock feedStock;


        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            IngredientPK that = (IngredientPK) o;

            if (!unit.equals(that.unit)) return false;
            return feedStock.equals(that.feedStock);
        }

        @Override
        public int hashCode() {
            int result = unit.hashCode();
            result = 31 * result + feedStock.hashCode();
            return result;
        }


    }
}
