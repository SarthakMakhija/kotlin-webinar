package org.meetkt.catalogue;

import org.junit.jupiter.api.Test;
import org.meetkt.catalogue.domain.model.Catalogue;
import org.meetkt.catalogue.domain.model.Product;
import org.meetkt.catalogue.domain.model.ProductId;
import org.meetkt.catalogue.exception.NoProductFoundForBarcodeException;

import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.meetkt.catalogue.fixture.ProductFixture.aProduct;

class BarcodeScannerUnitTest {

    @Test
    void shouldThrowAnExceptionGivenProductDoesNotExistForTheBarcode() {
        String barcode = "no-product-found-for-this-barcode";
        Catalogue catalogue = new Catalogue(Collections.emptyList());

        BarcodeScanner barcodeScanner = new BarcodeScanner(catalogue);

        assertThrows(NoProductFoundForBarcodeException.class,
                () -> barcodeScanner.scanOrThrow(barcode)
        );
    }

    @Test
    void shouldReturnAProductForABarcode() {
        String barcode = "product-001-barcode";
        Catalogue catalogue = new Catalogue(List.of(aProduct().withProductId("P-001").withBarcode(barcode).build()));
        BarcodeScanner barcodeScanner = new BarcodeScanner(catalogue);

        Product product = barcodeScanner.scanOrThrow(barcode);

        assertThat(product.id()).isEqualTo(new ProductId("P-001"));
    }
}
