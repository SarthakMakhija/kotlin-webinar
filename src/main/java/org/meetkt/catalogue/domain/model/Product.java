package org.meetkt.catalogue.domain.model;

import java.util.Objects;

public class Product {

    private final String id;
    private final String barcode;

    public Product(String id, String barcode) {
        this.id = Objects.requireNonNull(id);
        this.barcode = Objects.requireNonNull(barcode);
    }

    public String id() {
        return id;
    }

    public String barcode() {
        return barcode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Product)) return false;
        Product product = (Product) o;
        return id.equals(product.id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }
}
