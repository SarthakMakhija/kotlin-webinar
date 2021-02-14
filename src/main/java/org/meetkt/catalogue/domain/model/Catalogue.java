package org.meetkt.catalogue.domain.model;

import org.meetkt.cart.domain.model.Item;

import java.util.Map;
import java.util.Optional;

public class Catalogue {

    private final Map<String, Item> itemByBarcode;

    public Catalogue(Map<String, Item> itemByBarcode) {
        this.itemByBarcode = Map.copyOf(itemByBarcode);
    }

    public Optional<Item> itemFor(String barcode) {
        return Optional.ofNullable(itemByBarcode.get(barcode));
    }
}