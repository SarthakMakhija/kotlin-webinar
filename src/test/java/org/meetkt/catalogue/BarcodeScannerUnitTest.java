package org.meetkt.catalogue;

import org.junit.jupiter.api.Test;
import org.meetkt.catalogue.domain.model.Catalogue;
import org.meetkt.catalogue.domain.model.Product;
import org.meetkt.catalogue.domain.model.ProductId;
import org.meetkt.catalogue.exception.NoProductFoundForBarcodeException;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.meetkt.catalogue.fixture.ProductFixture.aProduct;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class BarcodeScannerUnitTest {

    @Test
    void shouldThrowAnExceptionGivenProductDoesNotExistForTheBarcode() {
        String barcode = "no-product-found-for-this-barcode";
        Catalogue catalogue = mock(Catalogue.class);
        when(catalogue.productWith(barcode)).thenReturn(Optional.empty());

        BarcodeScanner barcodeScanner = new BarcodeScanner(catalogue);
        assertThrows(NoProductFoundForBarcodeException.class,
                () -> barcodeScanner.scanOrThrow(barcode)
        );
    }

    @Test
    void shouldReturnAProductForABarcode() {
        String barcode = "product-001-barcode";
        Catalogue catalogue = mock(Catalogue.class);
        BarcodeScanner barcodeScanner = new BarcodeScanner(catalogue);
        when(catalogue.productWith(barcode)).thenReturn(Optional.of(aProduct().withProductId("001").withBarcode(barcode).build()));

        Product product = barcodeScanner.scanOrThrow(barcode);
        assertThat(product.id()).isEqualTo(new ProductId("001"));
    }
}