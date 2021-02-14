package org.meetkt.catalogue;

import org.meetkt.catalogue.exception.NoItemFoundForBarcodeException;

public class BarcodeScanner {

    public void scan(String barcode) {
        throw new NoItemFoundForBarcodeException(barcode);
    }
}
