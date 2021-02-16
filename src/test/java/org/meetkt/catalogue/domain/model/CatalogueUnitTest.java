package org.meetkt.catalogue.domain.model;

import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

class CatalogueUnitTest {

    @Test
    void shouldNoReturnAProductGivenCatalogueIsEmpty() {
        Catalogue catalogue = new Catalogue(Collections.emptyList());
        Optional<Product> product = catalogue.productWith("any-barcode");

        assertThat(product.isEmpty()).isTrue();
    }

    @Test
    void shouldNoReturnAProductGivenBarcodeIsNull() {
        Catalogue catalogue = new Catalogue(Collections.emptyList());
        Optional<Product> product = catalogue.productWith(null);

        assertThat(product.isEmpty()).isTrue();
    }

    @Test
    void shouldNoReturnAProductGivenProductDoesNotExistForTheBarcode() {
        Catalogue catalogue = new Catalogue(List.of(new Product("001", "barcode-001")));
        Optional<Product> product = catalogue.productWith("non-existent-product-for-barcode");

        assertThat(product.isEmpty()).isTrue();
    }

    @Test
    void shouldReturnAProductWithProductIdGivenABarcode() {
        Catalogue catalogue = new Catalogue(List.of(new Product("001", "barcode-001")));
        Optional<Product> product = catalogue.productWith("barcode-001");

        assertThat(product.get().id()).isEqualTo(new ProductId("001"));
    }
}