package org.meetkt.cart.domain.model;

import org.meetkt.catalogue.domain.model.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Cart {
    public static final int DEFAULT_PRODUCT_QUANTITY_IN_CART = 1;
    private List<CartItem> cartItems;

    public Cart() {
        this.cartItems = new ArrayList<>();
    }

    public void add(Product product) {
        this.cartItems.add(new CartItem(product, DEFAULT_PRODUCT_QUANTITY_IN_CART));
    }

    int totalItems() {
        return this.cartItems.size();
    }

    public void delete(CartItem anCartItem) {
        this.cartItems.remove(anCartItem);
    }

    public Optional<CartItem> find(Product product) {
        return this.cartItems
                .stream()
                .filter(cartItem -> cartItem.contains(product))
                .findFirst();
    }
}