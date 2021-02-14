package org.meetkt.catalogue.domain.model;

import org.junit.jupiter.api.Test;
import org.meetkt.cart.domain.model.Item;

import java.util.Collections;
import java.util.Map;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

class CatalogueUnitTest {

    @Test
    void shouldNoReturnAnItemGivenCatalogueIsEmpty() {
        Catalogue catalogue = new Catalogue(Collections.emptyMap());
        Optional<Item> item = catalogue.itemFor("any-barcode");

        assertThat(item.isEmpty()).isTrue();
    }

    @Test
    void shouldNoReturnAnItemGivenItemDoesNotExistForTheBarcode() {
        Catalogue catalogue = new Catalogue(Map.of("barcode-001", new Item("001")));
        Optional<Item> item = catalogue.itemFor("non-existent-item-for-barcode");

        assertThat(item.isEmpty()).isTrue();
    }

    @Test
    void shouldReturnAnItemWithProductIdGivenABarcode() {
        Catalogue catalogue = new Catalogue(Map.of("barcode-001", new Item("001")));
        Optional<Item> item = catalogue.itemFor("barcode-001");

        assertThat(item.get().productId()).isEqualTo("001");
    }
}