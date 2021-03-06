package `in`.meetkt.display.domain.model

import `in`.meetkt.basket.domain.model.Basket
import `in`.meetkt.basket.domain.model.Item
import `in`.meetkt.basket.domain.model.Items
import `in`.meetkt.basket.domain.model.Price
import `in`.meetkt.catalogue.fixture.ProductFixture
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class DisplayUnitTest {

    @Test
    fun shouldReturnItemsFromBasket() {
        val product = ProductFixture.aProduct().withProductId("001").withPriceDouble(12.21).build()
        val expectedItems = Items(mutableListOf(Item(product)))
        val basket = Basket.empty()
        basket.add(product)

        val display = Display(basket)

        assertThat(display.allBasketItems()).isEqualTo(expectedItems)
    }

    @Test
    fun shouldReturnTotalPriceOfAllItemsInBasket() {
        val basket = Basket.empty()
        basket.add(ProductFixture.aProduct().withProductId("001").withPriceInt(10).build())
        basket.add(ProductFixture.aProduct().withProductId("002").withPriceDouble(20.78).build())

        val display = Display(basket)

        assertThat(display.totalBasketPrice()).isEqualTo(Price(30.78))
    }
}