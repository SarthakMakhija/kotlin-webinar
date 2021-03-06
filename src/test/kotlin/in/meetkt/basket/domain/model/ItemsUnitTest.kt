package `in`.meetkt.basket.domain.model

import `in`.meetkt.catalogue.domain.model.ProductId
import `in`.meetkt.catalogue.fixture.ProductFixture
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class ItemsUnitTest {

    @Test
    fun shouldReturnAnEmptyItemGivenProductDoesNotExistInItems() {
        val product = ProductFixture.aProduct().withProductId("001").build()
        val items = Items(listOf(Item(product)))
        val item = items.findFirst(ProductId("non-existing"))

        assertThat(item).isNull()
    }

    @Test
    fun shouldReturnAnItem() {
        val product = ProductFixture.aProduct().withProductId("001").build()
        val items = Items(listOf(Item(product)))
        val item = items.findFirst(ProductId("001"))

        assertThat(item).isEqualTo(Item(product))
    }

    @Test
    fun shouldReturnTotalPrice() {
        val product =
            ProductFixture.aProduct().withProductId("001").withPriceInt(100).build()
        val otherProduct =
            ProductFixture.aProduct().withProductId("001").withPriceDouble(10.87).build()
        val items = Items(
            listOf(
                Item(product),
                Item(otherProduct)
            )
        )
        val totalPrice = items.totalPrice()
        assertThat(totalPrice).isEqualTo(Price(110.87))
    }
}