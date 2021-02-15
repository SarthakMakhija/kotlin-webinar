package org.meetkt.cart.domain.model;

import org.meetkt.catalogue.domain.model.Product;

public class Item {
    private Product product;
    private int quantity;

    public Item(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }
}
