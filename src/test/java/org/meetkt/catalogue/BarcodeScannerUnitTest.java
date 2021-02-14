package org.meetkt.catalogue;

import org.junit.jupiter.api.Test;
import org.meetkt.cart.domain.model.Item;
import org.meetkt.catalogue.exception.NoItemFoundForBarcodeException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class BarcodeScannerUnitTest {

    @Test
    void shouldThrowAnExceptionGivenItemDoesNotExistForTheBarcode() {
        BarcodeScanner barcodeScanner = new BarcodeScanner();
        assertThrows(NoItemFoundForBarcodeException.class,
                () -> barcodeScanner.scan("no-item-found-for-this-barcode")
        );
    }

    @Test
    void shouldReturnAnItemForABarcode() {
        BarcodeScanner barcodeScanner = new BarcodeScanner();
        Item item = barcodeScanner.scan("item-001-barcode");
        assertThat(item.productId()).isEqualTo("001");
    }
}