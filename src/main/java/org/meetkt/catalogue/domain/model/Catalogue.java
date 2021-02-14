package org.meetkt.catalogue.domain.model;

import java.util.Map;
import java.util.Optional;

public class Catalogue {

    private final Map<String, Product> productByBarcode;

    public Catalogue(Map<String, Product> productByBarcode) {
        this.productByBarcode = Map.copyOf(productByBarcode);
    }

    public Optional<Product> productFor(String barcode) {
        return Optional.ofNullable(productByBarcode.get(barcode));
    }
}