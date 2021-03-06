package org.meetkt.basket.domain.model;

import org.junit.jupiter.api.Test;
import org.meetkt.catalogue.domain.model.Product;
import org.meetkt.catalogue.domain.model.ProductId;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.meetkt.catalogue.fixture.ProductFixture.aProduct;

class ItemUnitTest {

    @Test
    void shouldReturnTrueGivenItemIsOfAGivenProduct() {
        Product product = aProduct().withProductId("001").build();
        Item item = new Item(product);

        boolean containsProduct = item.contains(new ProductId("001"));

        assertThat(containsProduct).isTrue();
    }

    @Test
    void shouldReturnFalseGivenItemIsNotOfGivenProduct() {
        Product product = aProduct().withProductId("001").build();
        Item item = new Item(product);

        boolean containsProduct = item.contains(new ProductId("002"));

        assertThat(containsProduct).isFalse();
    }
}