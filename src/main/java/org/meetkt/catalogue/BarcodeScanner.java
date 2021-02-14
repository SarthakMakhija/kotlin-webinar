package org.meetkt.catalogue;

import org.meetkt.cart.domain.model.Item;
import org.meetkt.catalogue.domain.model.Catalogue;
import org.meetkt.catalogue.exception.NoItemFoundForBarcodeException;

import java.util.Optional;

public class BarcodeScanner {

    private final Catalogue catalogue;

    public BarcodeScanner(Catalogue catalogue) {
        this.catalogue = catalogue;
    }

    public Item scan(String barcode) {
        Optional<Item> item = catalogue.itemFor(barcode);
        return item.orElseThrow(() -> new NoItemFoundForBarcodeException(barcode));
    }
}
