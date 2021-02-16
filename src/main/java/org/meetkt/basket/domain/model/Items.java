package org.meetkt.basket.domain.model;

import org.meetkt.catalogue.domain.model.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Items extends ArrayList<Item> {

    Items(List<Item> items) {
        super(items);
    }

    public Optional<Item> findFirst(Product product) {
        return this
                .stream()
                .filter(item -> item.contains(product))
                .findFirst();
    }
}