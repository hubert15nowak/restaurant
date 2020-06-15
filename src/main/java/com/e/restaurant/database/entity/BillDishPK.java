package com.e.restaurant.database.entity;

import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Embeddable
public class BillDishPK implements Serializable {

    @ManyToOne
    private Bill bill;

    @ManyToOne
    private Dish dish;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        BillDishPK that = (BillDishPK) o;

        if (!bill.equals(that.bill)) return false;
        return dish.equals(that.dish);
    }

    @Override
    public int hashCode() {
        int result = bill.hashCode();
        result = 31 * result + dish.hashCode();
        return result;
    }


    //Getters

    public Bill getBill() {
        return bill;
    }

    public Dish getDish() {
        return dish;
    }
}
