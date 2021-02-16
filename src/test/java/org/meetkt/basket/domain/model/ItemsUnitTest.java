package org.meetkt.basket.domain.model;

import org.junit.jupiter.api.Test;
import org.meetkt.catalogue.domain.model.Product;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

class ItemsUnitTest {

    @Test
    void shouldReturnAnEmptyItemGivenProductDoesNotExistInItems() {
        Product product = new Product("001", "barcode-001");
        Items items = new Items(List.of(new Item(product)));

        Optional<Item> item = items.findFirst(new Product("non-existing", "barcode-002"));

        assertThat(item).isEmpty();
    }

    @Test
    void shouldReturnAnItem() {
        Product product = new Product("001", "barcode-001");
        Items items = new Items(List.of(new Item(product)));

        Optional<Item> item = items.findFirst(new Product("001", "barcode-001"));

        assertThat(item.get()).isEqualTo(new Item(product));
    }
}