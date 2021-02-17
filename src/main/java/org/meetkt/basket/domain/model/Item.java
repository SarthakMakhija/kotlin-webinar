package org.meetkt.basket.domain.model;

import org.meetkt.catalogue.domain.model.Product;
import org.meetkt.catalogue.domain.model.ProductId;
import org.meetkt.display.domain.model.Price;

import java.util.Objects;

public class Item {

    private final ProductId productId;
    private final Price price;

    public Item(Product product) {
        this.productId = Objects.requireNonNull(product).id();
        this.price = Objects.requireNonNull(product).price();
    }

    //TODO: Think of a better name
    public boolean contains(ProductId productId) {
        return this.productId.equals(productId);
    }

    public int price() {
        return price.value();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Item)) return false;
        Item item = (Item) o;
        return Objects.equals(productId, item.productId);
    }

    @Override
    public int hashCode() {
        return productId.hashCode();
    }
}
