package `in`.meetkt.catalogue.domain.model

import `in`.meetkt.catalogue.fixture.ProductFixture
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class CatalogueUnitTest {

    @Test
    fun shouldNoReturnAProductGivenCatalogueIsEmpty() {
        val catalogue = Catalogue(emptyList())

        val product = catalogue.productWith("any-barcode")

        assertThat(product).isNull()
    }

    @Test
    fun shouldNoReturnAProductGivenProductDoesNotExistForTheBarcode() {
        val catalogue =
            Catalogue(listOf(ProductFixture.aProduct().withProductId("001").withBarcode("barcode-001").build()))

        val product = catalogue.productWith("non-existent-product-for-barcode")

        assertThat(product).isNull()
    }

    @Test
    fun shouldReturnAProductWithProductIdGivenABarcode() {
        val catalogue =
            Catalogue(listOf(ProductFixture.aProduct().withProductId("001").withBarcode("barcode-001").build()))

        val product = catalogue.productWith("barcode-001")

        assertThat(product!!.id).isEqualTo(ProductId("001"))
    }
}