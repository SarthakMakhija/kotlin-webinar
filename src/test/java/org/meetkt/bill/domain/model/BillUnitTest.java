package org.meetkt.bill.domain.model;

import org.junit.jupiter.api.Test;
import org.meetkt.basket.domain.model.Basket;
import org.meetkt.catalogue.domain.model.ProductId;
import org.meetkt.catalogue.fixture.ProductFixture;
import org.meetkt.display.domain.model.Price;

import static org.assertj.core.api.Assertions.assertThat;

class BillUnitTest {

    @Test
    void shouldReturnTotalItems() {
        Basket basket = Basket.empty();
        basket.add(ProductFixture.aProduct().withProductId("001").withPriceInt(10).build());
        basket.add(ProductFixture.aProduct().withProductId("002").withPriceDouble(20.78).build());

        Bill bill = Bill.of(basket);
        int totalItems = bill.totalItems();

        assertThat(totalItems).isEqualTo(2);
    }

    @Test
    void shouldReturnTotalPrice() {
        Basket basket = Basket.empty();
        basket.add(ProductFixture.aProduct().withProductId("001").withPriceDouble(20.78).build());
        basket.add(ProductFixture.aProduct().withProductId("001").withPriceDouble(20.78).build());

        Bill bill = Bill.of(basket);
        Price totalPrice = bill.totalPrice();

        assertThat(totalPrice).isEqualTo(new Price(41.56));
    }

    @Test
    void shouldReturnTotalItemsForAProductId() {
        Basket basket = Basket.empty();
        basket.add(ProductFixture.aProduct().withProductId("001").withPriceDouble(20.78).build());
        basket.add(ProductFixture.aProduct().withProductId("001").withPriceDouble(20.78).build());

        Bill bill = Bill.of(basket);
        int totalItems = bill.totalItemsFor(new ProductId("001"));

        assertThat(totalItems).isEqualTo(2);
    }
}