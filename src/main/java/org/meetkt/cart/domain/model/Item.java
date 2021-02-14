package org.meetkt.cart.domain.model;

public class Item {

    private final String productId;

    public Item(String productId) {
        this.productId = productId;
    }

    public String productId() {
        return productId;
    }
}
