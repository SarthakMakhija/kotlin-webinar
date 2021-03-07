package `in`.meetkt.catalogue.domain.model

import `in`.meetkt.catalogue.fixture.ProductFixture
import arrow.core.getOrElse
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class CatalogueUnitTest {

    @Test
    fun shouldNotReturnAProductGivenCatalogueIsEmpty() {
        val catalogue = Catalogue(emptyList())

        val product = catalogue.productWith("any-barcode")

        assertThat(product.isEmpty()).isTrue
    }

    @Test
    fun shouldNotReturnAProductGivenProductDoesNotExistForTheBarcode() {
        val catalogue =
                Catalogue(listOf(ProductFixture.aProduct().withProductId("001").withBarcode("barcode-001").build()))

        val product = catalogue.productWith("non-existent-product-for-barcode")

        assertThat(product.isEmpty()).isTrue
    }

    @Test
    fun shouldReturnAProductWithProductIdGivenABarcode() {
        val catalogue =
                Catalogue(listOf(ProductFixture.aProduct().withProductId("001").withBarcode("barcode-001").build()))

        val product = catalogue.productWith("barcode-001")

        assertThat(product.getOrElse { ProductFixture.aProduct().build() }.id).isEqualTo(ProductId("001"))
    }
}
