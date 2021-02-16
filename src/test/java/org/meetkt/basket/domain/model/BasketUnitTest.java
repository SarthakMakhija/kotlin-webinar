package org.meetkt.basket.domain.model;

import org.junit.jupiter.api.Test;
import org.meetkt.catalogue.domain.model.Product;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

class BasketUnitTest {

    @Test
    void shouldAddAProductInBasket() {
        Product product = new Product("001", "barcode-001");
        Basket basket = Basket.empty();

        basket.add(product);

        assertThat(basket.totalItems()).isEqualTo(1);
    }

    @Test
    void shouldAddMultipleProductsInBasketGivenSameProducts() {
        Basket basket = Basket.empty();

        basket.add(
                new Product("001", "barcode-001"),
                new Product("001", "barcode-001")
        );

        assertThat(basket.totalItems()).isEqualTo(2);
    }

    @Test
    void shouldAddMultipleProductsInBasketGivenDifferentProducts() {
        Basket basket = Basket.empty();

        basket.add(
                new Product("001", "barcode-001"),
                new Product("002", "barcode-002")
        );

        assertThat(basket.totalItems()).isEqualTo(2);
    }

    @Test
    void shouldDeleteAProductFromBasket() {
        Product product = new Product("001", "barcode-001");
        Basket basket = Basket.empty();
        basket.add(product);

        basket.delete(new Product("001", "barcode-001"));

        assertThat(basket.totalItems()).isZero();
    }

    @Test
    void shouldReturnTotalItemsInBasket() {
        Product product = new Product("001", "barcode-001");
        Basket basket = Basket.empty();
        basket.add(product);

        int totalItemsCount = basket.totalItems();

        assertThat(totalItemsCount).isEqualTo(1);
    }

    @Test
    void shouldReturnAnEmptyItemGivenProductDoesNotExistsInBasket() {
        Basket basket = Basket.empty();
        Product product = new Product("001", "barcode-001");

        Optional<Item> item = basket.find(product);

        assertThat(item).isEmpty();
    }

    @Test
    void shouldReturnAnItemFromBasket() {
        Basket basket = Basket.empty();
        Product product = new Product("001", "barcode-001");
        basket.add(product);

        Optional<Item> item = basket.find(new Product("001", "barcode-001"));

        assertThat(item.get()).isEqualTo(new Item(product));
    }
}