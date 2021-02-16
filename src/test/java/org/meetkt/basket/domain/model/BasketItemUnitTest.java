package org.meetkt.basket.domain.model;

import org.junit.jupiter.api.Test;
import org.meetkt.catalogue.domain.model.Product;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class BasketItemUnitTest {

    @Test
    void shouldReturnTrueGivenItemIsOfAGivenProduct() {
        Product product = new Product("001", "barcode-001");
        Item item = new Item(product);

        boolean containsProduct = item.contains(new Product("001", "barcode-001"));

        assertThat(containsProduct).isTrue();
    }

    @Test
    void shouldReturnFalseGivenItemIsNotOfGivenProduct() {
        Product product = new Product("001", "barcode-001");
        Item item = new Item(product);

        boolean containsProduct = item.contains(new Product("002", "barcode-002"));

        assertThat(containsProduct).isFalse();
    }
}