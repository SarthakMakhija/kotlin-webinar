package `in`.meetkt.basket.domain.model

import `in`.meetkt.catalogue.domain.model.ProductId

class Items(private val items: MutableList<Item>) : MutableList<Item> by items {

    fun totalPrice(): Price =
        items.map { it.price }.foldRight(Price.ZERO, { accumulator, price -> accumulator.add(price) })

    fun findFirst(productId: ProductId): Item? = items.firstOrNull { item -> item.contains(productId) }
}