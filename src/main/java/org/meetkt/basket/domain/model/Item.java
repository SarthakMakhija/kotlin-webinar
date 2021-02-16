package org.meetkt.basket.domain.model;

import org.meetkt.catalogue.domain.model.Product;

import java.util.Objects;

public class Item {

    private final Product product;
    private int quantity;

    public Item(Product product, int quantity) {
        this.product = Objects.requireNonNull(product);
        this.quantity = quantity;
    }

    public int quantity() {
        return this.quantity;
    }

    public boolean contains(Product product) {
        return this.product.equals(product);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return product.equals(item.product);
    }

    @Override
    public int hashCode() {
        return product.hashCode();
    }
}
