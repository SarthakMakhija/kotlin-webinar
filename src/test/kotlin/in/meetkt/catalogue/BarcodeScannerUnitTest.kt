package `in`.meetkt.catalogue

import `in`.meetkt.catalogue.domain.model.Catalogue
import `in`.meetkt.catalogue.domain.model.ProductId
import `in`.meetkt.catalogue.fixture.ProductFixture
import io.mockk.every
import io.mockk.mockk
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class BarcodeScannerUnitTest {

    @Test
    fun shouldReturnAnExceptionGivenProductDoesNotExistForTheBarcode() {
        val barcode = "no-product-found-for-this-barcode"
        val catalogue = mockk<Catalogue>()
        every { catalogue.productWith(barcode) } returns null
        val barcodeScanner = BarcodeScanner(catalogue)

        val product = barcodeScanner.scanOrThrow(barcode)

        assertThat(product.isLeft()).isTrue
    }

    @Test
    fun shouldReturnAProductForABarcode() {
        val barcode = "product-001-barcode"
        val catalogue = mockk<Catalogue>()
        val barcodeScanner = BarcodeScanner(catalogue)
        every { catalogue.productWith(barcode) } returns
                ProductFixture.aProduct().withProductId("001").withBarcode(barcode).build()

        val product = barcodeScanner.scanOrThrow(barcode)

        assertThat(product.orNull()?.id).isEqualTo(ProductId("001"))
    }
}
