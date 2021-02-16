package org.meetkt.catalogue.domain.model;

import java.util.Objects;

public class ProductId {

    private final String id;

    public ProductId(String id) {
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
