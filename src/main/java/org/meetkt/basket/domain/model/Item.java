package org.meetkt.basket.domain.model;

import org.meetkt.catalogue.domain.model.Product;

import java.util.Objects;

public class Item {

    private final String itemId;

    public Item(Product product) {
        this.itemId = Objects.requireNonNull(product).id();
    }

    //TODO: Think of a better name
    public boolean contains(String productId) {
        return this.itemId.equals(productId);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Item)) return false;
        Item item = (Item) o;
        return Objects.equals(itemId, item.itemId);
    }

    @Override
    public int hashCode() {
        return itemId.hashCode();
    }
}
