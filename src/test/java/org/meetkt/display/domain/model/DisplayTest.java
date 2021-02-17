package org.meetkt.display.domain.model;

import org.junit.jupiter.api.Test;
import org.meetkt.basket.domain.model.Basket;
import org.meetkt.basket.domain.model.Item;
import org.meetkt.basket.domain.model.Items;
import org.meetkt.catalogue.domain.model.Product;
import org.meetkt.catalogue.fixture.ProductFixture;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class DisplayTest {

    @Test
    void shouldReturnItemsFromBasket() {
        Product product = ProductFixture.aProduct().withProductId("001").build();
        Items expectedItems = new Items(List.of(new Item(product)));
        Basket basket = Basket.empty();
        basket.add(product);

        Display display = new Display(basket);

        assertThat(display.allBasketItems()).isEqualTo(expectedItems);
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