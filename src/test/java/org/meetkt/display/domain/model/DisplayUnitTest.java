package org.meetkt.display.domain.model;

import org.junit.jupiter.api.Test;
import org.meetkt.basket.domain.model.Basket;
import org.meetkt.basket.domain.model.Item;
import org.meetkt.basket.domain.model.Items;
import org.meetkt.invoice.domain.model.Invoice;
import org.meetkt.catalogue.domain.model.Product;
import org.meetkt.catalogue.fixture.ProductFixture;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class DisplayUnitTest {

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
        basket.add(ProductFixture.aProduct().withProductId("001").withPriceInt(10).build());
        basket.add(ProductFixture.aProduct().withProductId("002").withPriceDouble(20.78).build());

        Display display = new Display(basket);

        assertThat(display.totalBasketPrice()).isEqualTo(new Price(30.78));
    }

    @Test
    void shouldDisplayInvoiceWithOneItemForABasket() {
        Basket basket = Basket.empty();
        basket.add(ProductFixture.aProduct().withProductId("001").withPriceInt(10).build());
        Display display = new Display(basket);

        Invoice invoice = display.invoice();

        assertThat(invoice.totalItems()).isEqualTo(1);
    }
}