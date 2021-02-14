package org.meetkt.catalogue.domain.model;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;

import static java.util.stream.Collectors.toMap;

public class Catalogue {

    private final Map<String, Product> productByBarcode;

    public Catalogue(List<Product> products) {
        this.productByBarcode =
                products.stream().collect(toMap(Product::barcode, Function.identity()));
    }

    public Optional<Product> productFor(String barcode) {
        return Optional.ofNullable(productByBarcode.get(barcode));
    }
}