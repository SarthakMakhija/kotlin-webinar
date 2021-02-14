package org.meetkt.catalogue;

import org.junit.jupiter.api.Test;
import org.meetkt.catalogue.exception.NoItemFoundForBarcodeException;

import static org.junit.jupiter.api.Assertions.*;

class BarcodeScannerUnitTest {

    @Test
    void shouldThrowAnExceptionGivenItemDoesNotExistForTheBarcode() {
        BarcodeScanner barcodeScanner = new BarcodeScanner();
        assertThrows(NoItemFoundForBarcodeException.class,
                () -> barcodeScanner.scan("no-item-found-for-this-barcode")
        );
    }
}