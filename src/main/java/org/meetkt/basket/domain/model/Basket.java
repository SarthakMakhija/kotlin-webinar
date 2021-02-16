package org.meetkt.basket.domain.model;

import org.meetkt.catalogue.domain.model.Product;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Basket {

    public static final int DEFAULT_PRODUCT_QUANTITY_IN_BASKET = 1;
    private final List<Item> items;

    private Basket() {
        this.items = new ArrayList<>();
    }

    public static Basket empty() {
        return new Basket();
    }

    public void add(Product product) {
        this.items.add(new Item(product, DEFAULT_PRODUCT_QUANTITY_IN_BASKET));
    }

    public void add(Product... products) {
        Arrays.stream(products).forEach(this::add);
    }

    public void delete(Product product) {
        this.items.removeIf(item -> item.contains(product));
    }

    public Optional<Item> find(Product product) {
        return this.items
                .stream()
                .filter(item -> item.contains(product))
                .findFirst();
    }

    int totalItems() {
        return this.items.size();
    }
}