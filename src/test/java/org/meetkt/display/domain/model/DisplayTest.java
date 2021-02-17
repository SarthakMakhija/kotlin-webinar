package org.meetkt.display.domain.model;

import org.junit.jupiter.api.Test;
import org.meetkt.basket.domain.model.Basket;
import org.meetkt.catalogue.fixture.ProductFixture;

import static org.assertj.core.api.Assertions.assertThat;

class DisplayTest {

    @Test
    void shouldReturnItemsFromBasket() {
        Basket basket = Basket.empty();
        basket.add(ProductFixture.aProduct().withProductId("001").build());
        Display display = new Display(basket);

        assertThat(display.allBasketItems()).isEqualTo(basket.allItems());
    }

    @Test
    void shouldReturnTotalPriceOfAllItemsInBasket() {
        Basket basket = Basket.empty();
        basket.add(ProductFixture.aProduct().withProductId("001").withProductPrice(10).build());
        basket.add(ProductFixture.aProduct().withProductId("002").withProductPrice(20).build());
        Display display = new Display(basket);

        int expectedTotal = 30;
        assertThat(display.totalBasketPrice()).isEqualTo(expectedTotal);
    }
}