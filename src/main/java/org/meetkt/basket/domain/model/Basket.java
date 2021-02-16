package org.meetkt.basket.domain.model;

import org.meetkt.catalogue.domain.model.Product;
import org.meetkt.catalogue.domain.model.ProductId;

import java.util.Arrays;
import java.util.Collections;
import java.util.Optional;

public class Basket {

    private final Items items;

    private Basket() {
        this.items = new Items(Collections.emptyList());
    }

    public static Basket empty() {
        return new Basket();
    }

    public void add(Product product) {
        this.items.add(new Item(product));
    }

    public void add(Product... products) {
        Arrays.stream(products).forEach(this::add);
    }

    public void delete(Product product) {
        this.items.removeIf(item -> item.contains(new ProductId(product.id())));
    }

    public Optional<Item> findBy(ProductId productId) {
        return items.findFirst(productId);
    }

    public int totalItems() {
        return this.items.size();
    }
}

