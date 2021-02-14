package org.meetkt.catalogue.domain.model;

public class Product {

    private final String id;

    public Product(String id) {
        this.id = id;
    }

    public String id() {
        return id;
    }
}
