package `in`.meetkt.catalogue.exception

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class NoProductFoundForBarcodeExceptionUnitTest {

    @Test
    fun shouldReturnAnExceptionMessage() {
        val exception = NoProductFoundForBarcodeException("test-barcode")

        assertThat(exception.message).isEqualTo("No product found for test-barcode")
    }
}