package org.meetkt.catalogue.domain.model;

import org.meetkt.display.domain.model.Price;

import java.util.Objects;

public class Product {

    private final ProductId id;
    private final String barcode;
    private final Price price;

    public Product(ProductId id, String barcode, int price) {
        this.id = Objects.requireNonNull(id);
        this.barcode = Objects.requireNonNull(barcode);
        this.price = new Price(price);
    }

    public ProductId id() {
        return id;
    }

    public String barcode() {
        return barcode;
    }

    public Price price() {
        return price;
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
