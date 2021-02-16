package org.meetkt.cart.domain.model;

import org.meetkt.catalogue.domain.model.Product;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;

public class Cart {
    public static final int DEFAULT_PRODUCT_QUANTITY_IN_CART = 1;
    private final List<CartItem> cartItems;

    private Cart() {
        this.cartItems = new ArrayList<>();
    }

    public static Cart empty() {
        return new Cart();
    }

    public void add(Product product) {
        this.find(product)
                .ifPresentOrElse(
                        incrementExistingProductQuantity(),
                        addNew(product)
                );
    }

    public void add(Product... products) {
        Arrays.stream(products).forEach(this::add);
    }

    private Runnable addNew(Product product) {
        return () -> this.cartItems.add(new CartItem(product, DEFAULT_PRODUCT_QUANTITY_IN_CART));
    }

    private Consumer<CartItem> incrementExistingProductQuantity() {
        return (cartItem) -> {
            cartItem.incrementQuantity();
            this.cartItems.add(cartItem);
        };
    }

    int totalItems() {
        return this.cartItems.size();
    }

    public void delete(Product product) {
        this.cartItems.removeIf(cartItem -> cartItem.contains(product));
    }

    public Optional<CartItem> find(Product product) {
        return this.cartItems
                .stream()
                .filter(cartItem -> cartItem.contains(product))
                .findFirst();
    }
}