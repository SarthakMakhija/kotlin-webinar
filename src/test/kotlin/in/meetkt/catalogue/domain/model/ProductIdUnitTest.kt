package `in`.meetkt.catalogue.domain.model

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class ProductIdUnitTest {

    @Test
    fun shouldReturnTrueGiven2ProductIdsAreEqual() {
        val productId = ProductId("001")
        val otherProductId = ProductId("001")

        assertThat(productId).isEqualTo(otherProductId)
    }
}