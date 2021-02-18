package org.meetkt.basket.domain.model;

import org.junit.jupiter.api.Test;
import org.meetkt.catalogue.domain.model.Product;
import org.meetkt.catalogue.domain.model.ProductId;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.meetkt.catalogue.fixture.ProductFixture.aProduct;

class ItemsUnitTest {

    @Test
    void shouldReturnAnEmptyItemGivenProductDoesNotExistInItems() {
        Product product = aProduct().withProductId("001").build();
        Items items = new Items(List.of(new Item(product)));

        Optional<Item> item = items.findFirst(new ProductId("non-existing"));

        assertThat(item).isEmpty();
    }

    @Test
    void shouldReturnAnItem() {
        Product product = aProduct().withProductId("001").build();
        Items items = new Items(List.of(new Item(product)));

        Optional<Item> item = items.findFirst(new ProductId("001"));

        assertThat(item.get()).isEqualTo(new Item(product));
    }

    @Test
    void shouldReturnTotalPrice() {
        Product product = aProduct().withProductId("001").withPriceInt(100).build();
        Product otherProduct = aProduct().withProductId("001").withPriceDouble(10.87).build();
        Items items = new Items(List.of(new Item(product), new Item(otherProduct)));

        Price totalPrice = items.totalPrice();
        assertThat(totalPrice).isEqualTo(new Price(110.87));
    }
}