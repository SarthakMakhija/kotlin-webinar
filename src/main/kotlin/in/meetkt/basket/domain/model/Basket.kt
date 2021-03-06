package `in`.meetkt.basket.domain.model

import `in`.meetkt.catalogue.domain.model.Product
import `in`.meetkt.catalogue.domain.model.ProductId

class Basket {

    private val items: Items = Items(arrayListOf())

    companion object {
        fun empty(): Basket {
            return Basket()
        }
    }

    fun add(product: Product) {
        items += Item(product)
    }

    fun add(vararg products: Product) {
        products.forEach { items += Item(it) }
    }

    fun deleteAllProductsMatching(productId: ProductId) {
        items.removeIf { it.contains(productId) }
    }

    fun findBy(productId: ProductId): Item? = items.findFirst(productId)

    fun totalItems(): Int = items.size

    fun totalPrice(): Price = items.totalPrice()
}