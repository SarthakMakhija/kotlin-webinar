package org.meetkt.cart.domain.model;

import org.meetkt.catalogue.domain.model.Product;

import java.util.Objects;

public class Item {
    private Product product;
    private int quantity;

    public Item(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return quantity == item.quantity &&
                Objects.equals(product, item.product);
    }

    @Override
    public int hashCode() {
        return Objects.hash(product, quantity);
    }
}
