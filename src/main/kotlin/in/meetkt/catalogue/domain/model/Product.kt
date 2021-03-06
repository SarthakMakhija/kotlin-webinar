package `in`.meetkt.catalogue.domain.model

import `in`.meetkt.basket.domain.model.Price

class Product(
    val id: ProductId,
    val barcode: String,
    val price: Price
) {

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Product
        if (id != other.id) return false
        return true
    }

    override fun hashCode(): Int {
        return id.hashCode()
    }
}