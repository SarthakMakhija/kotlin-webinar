package org.meetkt.display.domain.model;

import org.junit.jupiter.api.Test;
import org.meetkt.basket.domain.model.Basket;
import org.meetkt.catalogue.fixture.ProductFixture;

import static org.assertj.core.api.Assertions.assertThat;

class DisplayTest {

    @Test
    void shouldReturnItemsFromBasket() {
        // GIVEN
        Basket basket = Basket.empty();
        basket.add(ProductFixture.aProduct().withProductId("abc").withBarcode("cba").build());
        Display display = new Display(basket);

        // WHEN + THEN
        assertThat(display.allBasketItems()).isEqualTo(basket.allItems());
    }

    @Test
    void shouldReturnTotalPriceOfAllItemsInBasket() {
        // GIVEN
        Basket basket = Basket.empty();
        basket.add(ProductFixture.aProduct().withProductId("abc").withBarcode("cba").withProductPrice(10).build());
        basket.add(ProductFixture.aProduct().withProductId("jan").withBarcode("naj").withProductPrice(20).build());
        Display display = new Display(basket);

        // WHEN + THEN
        int expectedTotal = 30;
        assertThat(display.totalBasketPrice()).isEqualTo(expectedTotal);
    }
}