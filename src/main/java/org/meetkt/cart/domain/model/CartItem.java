package org.meetkt.cart.domain.model;

import org.meetkt.catalogue.domain.model.Product;

import java.util.Objects;

public class CartItem {

    private final Product product;
    private int quantity;

    public CartItem(Product product, int quantity) {
        this.product = Objects.requireNonNull(product);
        this.quantity = quantity;
    }

    public int quantity() {
        return this.quantity;
    }

    public boolean contains(Product product) {
        return this.product.equals(product);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CartItem cartItem = (CartItem) o;
        return product.equals(cartItem.product);
    }

    @Override
    public int hashCode() {
        return product.hashCode();
    }

    public void incrementQuantity() {
        this.quantity = this.quantity + 1;
    }
}
