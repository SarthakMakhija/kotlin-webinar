package org.meetkt.cart.domain.model;

import org.meetkt.catalogue.domain.model.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Cart {
    public static final int DEFAULT_PRODUCT_QUANTITY_IN_CART = 1;
    private List<Item> items;

    public Cart() {
        this.items = new ArrayList<>();
    }

    public void add(Product product) {
        this.items.add(new Item(product, DEFAULT_PRODUCT_QUANTITY_IN_CART));
    }

    int totalItems() {
        return this.items.size();
    }

    public void delete(Item anItem) {
        this.items.remove(anItem);
    }

    public Optional<Item> find(Product product) {
        return this.items
                .stream()
                .filter(item -> item.contains(product))
                .findFirst();
    }
}