package org.meetkt.catalogue.domain.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.meetkt.catalogue.fixture.ProductFixture.aProduct;

class ProductUnitTest {

    @Test
    void shouldReturnProductDescriptionInLowerCase() {
        Product product = aProduct()
                .withProductId("P-1000")
                .withDescription("Product Description")
                .build();

        final String description = product.description();

        Assertions.assertThat(description).isEqualTo("product description");
    }
}
