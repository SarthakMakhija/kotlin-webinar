package org.meetkt.cart.domain.model;

import org.junit.jupiter.api.Test;
import org.meetkt.catalogue.domain.model.Product;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

class CartUnitTest {

    @Test
    void shouldAddAProductInCart() {
        Product product = new Product("001", "barcode-001");
        Cart cart = new Cart();

        cart.add(product);

        assertThat(cart.totalItems()).isEqualTo(1);
    }

    @Test
    void shouldDeleteAnItemFromCart() {
        Product product = new Product("001", "barcode-001");
        Cart cart = new Cart();
        cart.add(product);

        cart.delete(new Item(product, 1));

        assertThat(cart.totalItems()).isZero();
    }

    @Test
    void shouldReturnTotalItemsInCart() {
        Product product = new Product("001", "barcode-001");
        Cart cart = new Cart();
        cart.add(product);

        int totalItemsCount = cart.totalItems();

        assertThat(totalItemsCount).isEqualTo(1);
    }

    @Test
    void shouldReturnAnEmptyItemGivenProductDoesNotExistsInCart() {
        Cart cart = new Cart();

        Optional<Item> item = cart.find(new Product("001", "barcode-001"));

        assertThat(item).isEmpty();
    }

    @Test
    void shouldReturnAnItemFromCart() {
        Product product = new Product("001", "barcode-001");
        Cart cart = new Cart();
        cart.add(product);

        Optional<Item> item = cart.find(new Product("001", "barcode-001"));

        assertThat(item.get().quantity()).isEqualTo(1);
    }
}