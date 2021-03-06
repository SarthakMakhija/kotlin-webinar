package `in`.meetkt.basket.domain.model

import `in`.meetkt.catalogue.domain.model.Product
import `in`.meetkt.catalogue.domain.model.ProductId

class Item(product: Product) {

    val productId = product.id
    val price = product.price

    fun contains(productId: ProductId): Boolean {
        return this.productId == productId
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Item
        if (productId != other.productId) return false
        return true
    }

    override fun hashCode(): Int {
        return productId.hashCode()
    }

    override fun toString(): String {
        return "Item(productId=$productId, price=$price)"
    }
}