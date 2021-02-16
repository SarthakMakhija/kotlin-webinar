package org.meetkt.cart.domain.model;

import org.junit.jupiter.api.Test;
import org.meetkt.catalogue.domain.model.Product;

import static org.assertj.core.api.Assertions.assertThat;

class CartUnitTest {

    @Test
    void shouldAddAnItemToCart() {
        Product product = new Product("001", "barcode-001");
        Item item = new Item(product, 1);
        Cart cart = new Cart();

        cart.add(item);

        assertThat(cart.totalItems()).isEqualTo(1);
    }

    @Test
    void shouldDeleteAnItemFromCart() {
        Product product = new Product("001", "barcode-001");
        Item item = new Item(product, 1);
        Cart cart = new Cart();
        cart.add(item);

        cart.delete(new Item(product, 1));

        assertThat(cart.totalItems()).isZero();
    }

    @Test
    void shouldReturnTotalItemsInCart() {
        Product product = new Product("001", "barcode-001");
        Item item = new Item(product, 1);
        Cart cart = new Cart();
        cart.add(item);

        assertThat(cart.totalItems()).isEqualTo(1);
    }
}