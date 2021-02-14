package org.meetkt.catalogue.domain.model;

import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

class CatalogueUnitTest {

    @Test
    void shouldNoReturnAnProductGivenCatalogueIsEmpty() {
        Catalogue catalogue = new Catalogue(Collections.emptyList());
        Optional<Product> product = catalogue.productFor("any-barcode");

        assertThat(product.isEmpty()).isTrue();
    }

    @Test
    void shouldNoReturnAnProductGivenProductDoesNotExistForTheBarcode() {
        Catalogue catalogue = new Catalogue(List.of(new Product("001", "barcode-001")));
        Optional<Product> product = catalogue.productFor("non-existent-product-for-barcode");

        assertThat(product.isEmpty()).isTrue();
    }

    @Test
    void shouldReturnAnProductWithProductIdGivenABarcode() {
        Catalogue catalogue = new Catalogue(List.of(new Product("001", "barcode-001")));
        Optional<Product> product = catalogue.productFor("barcode-001");

        assertThat(product.get().id()).isEqualTo("001");
    }
}