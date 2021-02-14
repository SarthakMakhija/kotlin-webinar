package org.meetkt.catalogue;

import org.meetkt.catalogue.domain.model.Catalogue;
import org.meetkt.catalogue.domain.model.Product;
import org.meetkt.catalogue.exception.NoProductFoundForBarcodeException;

import java.util.Optional;

public class BarcodeScanner {

    private final Catalogue catalogue;

    public BarcodeScanner(Catalogue catalogue) {
        this.catalogue = catalogue;
    }

    public Product scanOrThrow(String barcode) {
        Optional<Product> product = catalogue.productFor(barcode);
        return product.orElseThrow(() -> new NoProductFoundForBarcodeException(barcode));
    }
}
