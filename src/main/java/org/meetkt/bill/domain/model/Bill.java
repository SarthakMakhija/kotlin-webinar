package org.meetkt.bill.domain.model;

import org.meetkt.basket.domain.model.Basket;

public class Bill {

    private final Basket basket;

    private Bill(Basket basket) {
        this.basket = basket;
    }

    public static Bill of(Basket basket) {
        return new Bill(basket);
    }

    public int totalItems() {
        return basket.totalItems();
    }
}