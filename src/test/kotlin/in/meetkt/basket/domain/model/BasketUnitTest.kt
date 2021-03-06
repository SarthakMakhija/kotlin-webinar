package `in`.meetkt.basket.domain.model

import `in`.meetkt.catalogue.domain.model.ProductId
import `in`.meetkt.catalogue.fixture.ProductFixture
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class BasketUnitTest {

    @Test
    fun shouldAddAProductInBasket() {
        val product = ProductFixture.aProduct().withProductId("001").build()
        val basket = Basket.empty()

        basket.add(product)

        assertThat(basket.totalItems()).isEqualTo(1)
    }

    @Test
    fun shouldAddMultipleProductsInBasketGivenSameProducts() {
        val basket = Basket.empty()

        basket.add(
            ProductFixture.aProduct().withProductId("001").build(),
            ProductFixture.aProduct().withProductId("001").build()
        )

        assertThat(basket.totalItems()).isEqualTo(2)
    }

    @Test
    fun shouldAddMultipleProductsInBasketGivenDifferentProducts() {
        val basket = Basket.empty()

        basket.add(
            ProductFixture.aProduct().withProductId("001").build(),
            ProductFixture.aProduct().withProductId("002").build()
        )

        assertThat(basket.totalItems()).isEqualTo(2)
    }

    @Test
    fun shouldDeleteAllProductsMatchingProductId() {
        val product = ProductFixture.aProduct().withProductId("001").build()
        val basket = Basket.empty()
        basket.add(product)
        basket.add(product)

        basket.deleteAllProductsMatching(ProductId("001"))

        assertThat(basket.totalItems()).isEqualTo(0)
    }

    @Test
    fun shouldReturnTotalItemsInBasket() {
        val product = ProductFixture.aProduct().withProductId("001").build()
        val basket = Basket.empty()
        basket.add(product)

        val totalItemsCount = basket.totalItems()

        assertThat(totalItemsCount).isEqualTo(1)
    }

    @Test
    fun shouldReturnAnEmptyItemGivenProductDoesNotExistInBasket() {
        val basket = Basket.empty()

        val item = basket.findBy(ProductId("001"))

        assertThat(item).isNull()
    }

    @Test
    fun shouldReturnAnItemFromBasket() {
        val basket = Basket.empty()
        val product = ProductFixture.aProduct().withProductId("001").build()
        basket.add(product)

        val item = basket.findBy(ProductId("001"))

        assertThat(item).isEqualTo(Item(product))
    }

    @Test
    fun shouldReturnTotalBasketPrice() {
        val basket = Basket.empty()
        val product = ProductFixture.aProduct().withProductId("001").withPriceInt(12).build()
        val otherProduct = ProductFixture.aProduct().withProductId("001").withPriceDouble(14.75).build()
        basket.add(product, otherProduct)

        val totalPrice = basket.totalPrice()

        assertThat(totalPrice).isEqualTo(Price(26.75))
    }
}