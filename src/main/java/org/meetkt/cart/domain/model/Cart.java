package org.meetkt.cart.domain.model;

import java.util.ArrayList;
import java.util.List;

public class Cart {
    private List<Item> items;

    public Cart() {
        this.items = new ArrayList<>();
    }

    public void add(Item anItem) {
        this.items.add(anItem);
    }

    int totalItems() {
        return this.items.size();
    }

    public void delete(Item anItem) {
        this.items.remove(anItem);
    }
}