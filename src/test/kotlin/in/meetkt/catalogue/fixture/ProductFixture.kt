package `in`.meetkt.catalogue.fixture

import `in`.meetkt.basket.domain.model.Price
import `in`.meetkt.catalogue.domain.model.Product
import `in`.meetkt.catalogue.domain.model.ProductId

class ProductFixture private constructor() {

    private var barcode = "ZZZZZZZ"
    private var productId: ProductId = ProductId("00000")
    private var price = Price.ZERO

    companion object {
        fun aProduct() = ProductFixture()
    }

    fun build(): Product = Product(productId, barcode, price)

    fun withProductId(id: String): ProductFixture = this.also { it.productId = ProductId(id) }

    fun withBarcode(barcode: String): ProductFixture = this.also { it.barcode = barcode }

    fun withPriceInt(price: Int) = withPriceDouble(price.toDouble())

    fun withPriceDouble(price: Double) = this.also { it.price = Price(price) }
}