package org.meetkt.catalogue.exception;

public class NoItemFoundForBarcodeException extends RuntimeException {

    public NoItemFoundForBarcodeException(String barcode) {
        super(String.format("No item found for %s", barcode));
    }
}
