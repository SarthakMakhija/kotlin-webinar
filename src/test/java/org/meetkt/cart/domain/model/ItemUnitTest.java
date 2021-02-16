package org.meetkt.cart.domain.model;

import org.junit.jupiter.api.Test;
import org.meetkt.catalogue.domain.model.Product;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class ItemUnitTest {

    @Test
    void shouldReturnTrueGivenItemIsOfAGivenProduct() {
        Product product = new Product("001", "barcode-001");
        Item item = new Item(product, 1);

        boolean containsProduct = item.contains(new Product("001", "barcode-001"));

        assertThat(containsProduct).isTrue();
    }

    @Test
    void shouldReturnFalseGivenItemIsNotOfGivenProduct() {
        Product product = new Product("001", "barcode-001");
        Item item = new Item(product, 1);

        boolean containsProduct = item.contains(new Product("002", "barcode-002"));

        assertThat(containsProduct).isFalse();
    }
}