package org.meetkt.catalogue.exception;

public class NoProductFoundForBarcodeException extends RuntimeException {

    public NoProductFoundForBarcodeException(String barcode) {
        super(String.format("No product found for %s", barcode));
    }
}
