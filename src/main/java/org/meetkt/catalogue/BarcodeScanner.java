package org.meetkt.catalogue;

import org.meetkt.catalogue.domain.model.Catalogue;
import org.meetkt.catalogue.domain.model.Product;
import org.meetkt.catalogue.exception.NoProductFoundForBarcodeException;

import java.util.Objects;
import java.util.Optional;

public class BarcodeScanner {

    private final Catalogue catalogue;

    public BarcodeScanner(Catalogue catalogue) {
        this.catalogue = Objects.requireNonNull(catalogue);
    }

    public Product scanOrThrow(String barcode) {
        Optional<Product> product = catalogue.productWith(barcode);
        return product.orElseThrow(() -> new NoProductFoundForBarcodeException(barcode));
    }
}