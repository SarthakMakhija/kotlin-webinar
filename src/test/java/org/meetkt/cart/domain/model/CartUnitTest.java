package org.meetkt.cart.domain.model;

import org.junit.jupiter.api.Test;
import org.meetkt.catalogue.domain.model.Product;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

class CartUnitTest {

    @Test
    void shouldAddAProductInCart() {
        Product product = new Product("001", "barcode-001");
        Cart cart = Cart.empty();

        cart.add(product);

        Optional<CartItem> cartItem = cart.find(new Product("001", "barcode-001"));
        assertThat(cartItem.get().quantity()).isEqualTo(1);
    }

    @Test
    void shouldIncrementTheItemQuantityGivenExistingProductIsAdded() {
        Product product = new Product("001", "barcode-001");
        Cart cart = Cart.empty();
        cart.add(product);

        cart.add(product);

        Optional<CartItem> cartItem = cart.find(new Product("001", "barcode-001"));
        assertThat(cartItem.get().quantity()).isEqualTo(2);
    }

    @Test
    void shouldDeleteAProductFromCart() {
        Product product = new Product("001", "barcode-001");
        Cart cart = Cart.empty();
        cart.add(product);

        cart.delete(new Product("001", "barcode-001"));

        assertThat(cart.totalItems()).isZero();
    }

    @Test
    void shouldReturnTotalItemsInCart() {
        Product product = new Product("001", "barcode-001");
        Cart cart = Cart.empty();
        cart.add(product);

        int totalItemsCount = cart.totalItems();

        assertThat(totalItemsCount).isEqualTo(1);
    }

    @Test
    void shouldReturnAnEmptyItemGivenProductDoesNotExistsInCart() {
        Cart cart = Cart.empty();
        Product product = new Product("001", "barcode-001");

        Optional<CartItem> item = cart.find(product);

        assertThat(item).isEmpty();
    }

    @Test
    void shouldReturnAnItemFromCart() {
        Cart cart = Cart.empty();
        Product product = new Product("001", "barcode-001");
        cart.add(product);

        Optional<CartItem> item = cart.find(new Product("001", "barcode-001"));

        assertThat(item.get().quantity()).isEqualTo(1);
    }
}