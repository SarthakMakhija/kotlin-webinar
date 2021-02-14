package org.meetkt.catalogue;

import org.meetkt.cart.domain.model.Item;
import org.meetkt.catalogue.exception.NoItemFoundForBarcodeException;

public class BarcodeScanner {

    public Item scan(String barcode) {
        if(barcode.equals("item-001-barcode"))
            return new Item();

        throw new NoItemFoundForBarcodeException(barcode);
    }
}
