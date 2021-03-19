package org.meetkt.catalogue.domain.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

class ProductIdUnitTest {

    @Test
    void shouldThrowExceptionGivenProductIdLessThanMinimumLength() {
        assertThrows(IllegalArgumentException.class, () -> new ProductId("P-1"));
    }
}
