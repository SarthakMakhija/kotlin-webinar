package org.meetkt.display.domain.model;

import org.meetkt.basket.domain.model.Basket;
import org.meetkt.basket.domain.model.Items;

public class Display {

    private final Basket basket;

    public Display(Basket basket) { this.basket = basket; }

    public Items getItemsInBasket() { return basket.getItems(); }
}
