package org.meetkt.display.domain.model;

public class Price {

    private final int value;

    public Price(int value) {
        this.value = value;
    }

    public Price add(Price other) {
        return new Price(this.value + other.value);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Price)) return false;
        Price price = (Price) o;
        return value == price.value;
    }

    @Override
    public int hashCode() {
        return Integer.hashCode(value);
    }
}
