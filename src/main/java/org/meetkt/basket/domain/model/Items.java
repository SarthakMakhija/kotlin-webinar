package org.meetkt.basket.domain.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Items extends ArrayList<Item> {

    Items(List<Item> items) {
        super(items);
    }

    public Optional<Item> findFirst(String productId) {
        return this
                .stream()
                .filter(item -> item.contains(productId))
                .findFirst();
    }
}