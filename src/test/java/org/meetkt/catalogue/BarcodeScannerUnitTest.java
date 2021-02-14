package org.meetkt.catalogue;

import org.junit.jupiter.api.Test;
import org.meetkt.cart.domain.model.Item;
import org.meetkt.catalogue.domain.model.Catalogue;
import org.meetkt.catalogue.exception.NoItemFoundForBarcodeException;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class BarcodeScannerUnitTest {

    @Test
    void shouldThrowAnExceptionGivenItemDoesNotExistForTheBarcode() {
        String barcode = "no-item-found-for-this-barcode";
        Catalogue catalogue = mock(Catalogue.class);
        when(catalogue.itemForm(barcode)).thenReturn(Optional.empty());

        BarcodeScanner barcodeScanner = new BarcodeScanner(catalogue);
        assertThrows(NoItemFoundForBarcodeException.class,
                () -> {
                    barcodeScanner.scan(barcode);
                }
        );
    }

    @Test
    void shouldReturnAnItemForABarcode() {
        String barcode = "item-001-barcode";
        Catalogue catalogue = mock(Catalogue.class);
        BarcodeScanner barcodeScanner = new BarcodeScanner(catalogue);
        when(catalogue.itemForm(barcode)).thenReturn(Optional.of(new Item("001")));

        Item item = barcodeScanner.scan(barcode);
        assertThat(item.productId()).isEqualTo("001");
    }
}