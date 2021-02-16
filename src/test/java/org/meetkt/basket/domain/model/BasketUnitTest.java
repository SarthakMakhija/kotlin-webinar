package org.meetkt.basket.domain.model;

import org.junit.jupiter.api.Test;
import org.meetkt.catalogue.domain.model.Product;
import org.meetkt.catalogue.domain.model.ProductId;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.meetkt.catalogue.fixture.ProductFixture.aProduct;

class BasketUnitTest {

    @Test
    void shouldAddAProductInBasket() {
        Product product = aProduct().withProductId("001").build();
        Basket basket = Basket.empty();

        basket.add(product);

        assertThat(basket.totalItems()).isEqualTo(1);
    }

    @Test
    void shouldAddMultipleProductsInBasketGivenSameProducts() {
        Basket basket = Basket.empty();

        basket.add(
                aProduct().withProductId("001").build(),
                aProduct().withProductId("001").build()
        );

        assertThat(basket.totalItems()).isEqualTo(2);
    }

    @Test
    void shouldAddMultipleProductsInBasketGivenDifferentProducts() {
        Basket basket = Basket.empty();

        basket.add(
                aProduct().withProductId("001").build(),
                aProduct().withProductId("002").build()
        );

        assertThat(basket.totalItems()).isEqualTo(2);
    }

    @Test
    void shouldDeleteAProductFromBasket() {
        Product product = aProduct().withProductId("001").build();
        Basket basket = Basket.empty();
        basket.add(product);

        basket.delete(aProduct().withProductId("001").build());

        assertThat(basket.totalItems()).isZero();
    }

    @Test
    void shouldReturnTotalItemsInBasket() {
        Product product = aProduct().withProductId("001").build();
        Basket basket = Basket.empty();
        basket.add(product);

        int totalItemsCount = basket.totalItems();

        assertThat(totalItemsCount).isEqualTo(1);
    }

    @Test
    void shouldReturnAnEmptyItemGivenProductDoesNotExistInBasket() {
        Basket basket = Basket.empty();

        Optional<Item> item = basket.findBy(new ProductId("001"));

        assertThat(item).isEmpty();
    }

    @Test
    void shouldReturnAnItemFromBasket() {
        Basket basket = Basket.empty();
        Product product = aProduct().withProductId("001").build();
        basket.add(product);

        Optional<Item> item = basket.findBy(new ProductId("001"));

        assertThat(item.get()).isEqualTo(new Item(product));
    }
}