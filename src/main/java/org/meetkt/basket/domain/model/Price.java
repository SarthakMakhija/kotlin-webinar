package org.meetkt.basket.domain.model;

public class Price {

    public static final Price ZERO = new Price(0);

    private final double value;

    public Price(double value) {
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
        return Double.compare(value, price.value) == 0;
    }

    @Override
    public int hashCode() {
        return Double.hashCode(value);
    }

    @Override
    public String toString() {
        return "Price{" +
                "value=" + value +
                '}';
    }
}
