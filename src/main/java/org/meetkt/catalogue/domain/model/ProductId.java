package org.meetkt.catalogue.domain.model;

import java.util.Objects;

public class ProductId {
    private final static int MINIMUM_PRODUCT_ID_LENGTH = 4;

    private final String id;

    public ProductId(String id) {
        Objects.requireNonNull(id);
        if (id.length() < MINIMUM_PRODUCT_ID_LENGTH) {
            throw new IllegalArgumentException("product id must be longer than 4 characters, actual are :" + id.length());
        }
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ProductId)) return false;
        ProductId productId = (ProductId) o;
        return Objects.equals(id, productId.id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }
}
