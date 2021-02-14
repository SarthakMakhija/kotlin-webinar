package org.meetkt.catalogue.domain.model;

public class Product {

    private final String id;
    private final String barcode;

    public Product(String id, String barcode) {
        this.id = id;
        this.barcode = barcode;
    }

    public String id() {
        return id;
    }

    public String barcode() {
        return barcode;
    }
}
