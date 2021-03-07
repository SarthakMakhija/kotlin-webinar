package `in`.meetkt.invoice.domain.model

import `in`.meetkt.basket.domain.model.Basket
import `in`.meetkt.basket.domain.model.Price
import `in`.meetkt.catalogue.domain.model.ProductId
import `in`.meetkt.catalogue.fixture.ProductFixture
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class InvoiceUnitTest {

    @Test
    fun shouldReturnTotalItems() {
        val basket = Basket.empty()
        basket.add(ProductFixture.aProduct().withProductId("001").withPriceInt(10).build())
        basket.add(ProductFixture.aProduct().withProductId("002").withPriceDouble(20.78).build())

        val invoice = Invoice.`for`(basket)

        val totalItems = invoice.totalItems()
        assertThat(totalItems).isEqualTo(2)
    }

    @Test
    fun shouldReturnTotalPrice() {
        val basket = Basket.empty()
        basket.add(ProductFixture.aProduct().withProductId("001").withPriceDouble(20.78).build())
        basket.add(ProductFixture.aProduct().withProductId("001").withPriceDouble(20.78).build())

        val invoice = Invoice.`for`(basket)

        val totalPrice = invoice.totalPrice()
        assertThat(totalPrice).isEqualTo(Price(41.56))
    }

    @Test
    fun shouldReturnTotalItemsForAProductId() {
        val basket = Basket.empty()
        basket.add(ProductFixture.aProduct().withProductId("001").withPriceDouble(20.78).build())
        basket.add(ProductFixture.aProduct().withProductId("001").withPriceDouble(20.78).build())

        val invoice = Invoice.`for`(basket)
        val totalItems = invoice.totalItemsFor(ProductId("001"))

        assertThat(totalItems).isEqualTo(2)
    }
}