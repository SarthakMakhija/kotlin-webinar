package org.meetkt.display.domain.model;

import org.meetkt.basket.domain.model.Basket;
import org.meetkt.basket.domain.model.Items;

import java.util.Objects;

public class Display {

    private final Basket basket;

    public Display(Basket basket) {
        this.basket = Objects.requireNonNull(basket);
    }

    public Price totalBasketPrice() {
        return basket.totalPrice();
    }

    public Items allBasketItems() {
        return basket.allItems();
    }
}
