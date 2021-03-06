package `in`.meetkt.basket.domain.model

import `in`.meetkt.catalogue.domain.model.ProductId
import `in`.meetkt.catalogue.fixture.ProductFixture
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class ItemUnitTest {

    @Test
    fun shouldReturnTrueGivenItemIsOfAGivenProduct() {
        val product = ProductFixture.aProduct().withProductId("001").build()
        val item = Item(product)

        val containsProduct = item.contains(ProductId("001"))

        assertThat(containsProduct).isTrue
    }

    @Test
    fun shouldReturnFalseGivenItemIsNotOfGivenProduct() {
        val product = ProductFixture.aProduct().withProductId("001").build()
        val item = Item(product)

        val containsProduct = item.contains(ProductId("002"))

        assertThat(containsProduct).isFalse
    }

    @Test
    fun shouldReturnTrueGiven2ItemAreEqual() {
        val product = ProductFixture.aProduct().withProductId("001").withPriceDouble(12.21).build()
        val item = Item(product)
        val otherItem = Item(product)

        assertThat(item).isEqualTo(otherItem)
    }
}