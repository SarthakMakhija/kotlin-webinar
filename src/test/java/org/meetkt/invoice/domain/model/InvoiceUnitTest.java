package org.meetkt.invoice.domain.model;

import org.junit.jupiter.api.Test;
import org.meetkt.basket.domain.model.Basket;
import org.meetkt.catalogue.domain.model.ProductId;
import org.meetkt.catalogue.fixture.ProductFixture;
import org.meetkt.basket.domain.model.Price;

import static org.assertj.core.api.Assertions.assertThat;

class InvoiceUnitTest {

    @Test
    void shouldReturnTotalItems() {
        Basket basket = Basket.empty();
        basket.add(ProductFixture.aProduct().withProductId("P-001").withPriceInt(10).build());
        basket.add(ProductFixture.aProduct().withProductId("P-002").withPriceDouble(20.78).build());

        Invoice invoice = Invoice.of(basket);
        int totalItems = invoice.totalItems();

        assertThat(totalItems).isEqualTo(2);
    }

    @Test
    void shouldReturnTotalPrice() {
        Basket basket = Basket.empty();
        basket.add(ProductFixture.aProduct().withProductId("P-001").withPriceDouble(20.78).build());
        basket.add(ProductFixture.aProduct().withProductId("P-001").withPriceDouble(20.78).build());

        Invoice invoice = Invoice.of(basket);
        Price totalPrice = invoice.totalPrice();

        assertThat(totalPrice).isEqualTo(new Price(41.56));
    }

    @Test
    void shouldReturnTotalItemsForAProductId() {
        Basket basket = Basket.empty();
        basket.add(ProductFixture.aProduct().withProductId("P-001").withPriceDouble(20.78).build());
        basket.add(ProductFixture.aProduct().withProductId("P-001").withPriceDouble(20.78).build());

        Invoice invoice = Invoice.of(basket);
        int totalItems = invoice.totalItemsFor(new ProductId("P-001"));

        assertThat(totalItems).isEqualTo(2);
    }
}
