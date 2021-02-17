package org.meetkt.display.domain.model;

import org.meetkt.basket.domain.model.Basket;
import org.meetkt.basket.domain.model.Item;
import org.meetkt.basket.domain.model.Items;

public class Display {

    private final Basket basket;

    public Display(Basket basket) { this.basket = basket; }

    public int getTotalPriceOfAllItems() {
        return basket.getItems().stream().mapToInt(Item::getPrice).sum();
    }

    public Items getItemsInBasket() { return basket.getItems(); }
}
