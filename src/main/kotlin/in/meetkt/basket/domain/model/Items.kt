package `in`.meetkt.basket.domain.model

import `in`.meetkt.catalogue.domain.model.ProductId

class Items(private val items: MutableList<Item>) : MutableList<Item> by items {

    fun totalPrice(): Price =
        items.map { it.price }.foldRight(Price.ZERO, { accumulator, price -> accumulator.add(price) })

    fun findFirst(productId: ProductId): Item? = items.firstOrNull { item -> item.contains(productId) }

    override fun toString(): String {
        return "Items(items=$items)"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Items
        if (items != other.items) return false
        return true
    }

    override fun hashCode(): Int {
        return items.hashCode()
    }
}