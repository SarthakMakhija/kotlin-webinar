package `in`.meetkt.invoice.domain.model

import `in`.meetkt.basket.domain.model.Basket
import `in`.meetkt.basket.domain.model.Items
import `in`.meetkt.basket.domain.model.Price
import `in`.meetkt.catalogue.domain.model.ProductId

class Invoice private constructor(private val invoicedItems: InvoicedItems) {

    companion object {
        fun `for`(basket: Basket) = Invoice(InvoicedItems.from(basket.allItems()))
    }

    fun totalItems() = invoicedItems.totalItems()

    fun totalPrice() = invoicedItems.totalPrice()

    fun totalItemsFor(productId: ProductId) = invoicedItems.totalItemsFor(productId)
}

class InvoicedItems private constructor(items: List<InvoicedItem>) : List<InvoicedItems.InvoicedItem> by items {

    companion object {
        fun from(items: Items) =
            InvoicedItems(
                items
                    .groupBy { item -> item.productId }
                    .map { it.key to Items(it.value.toMutableList()) }
                    .map(InvoicedItem::from)
            )
    }

    fun totalItems() = this.map { it.quantity }.sum()

    fun totalPrice() =
        this.map { it.totalPrice }.foldRight(Price.ZERO, { accumulator, price -> accumulator.add(price) })

    fun totalItemsFor(productId: ProductId) = this.filter { it.matches(productId) }.map { it.quantity }.sum()


    class InvoicedItem private constructor(
        private val productId: ProductId,
        val quantity: Int,
        val totalPrice: Price
    ) {

        companion object {
            fun from(itemsByProductId: Pair<ProductId, Items>) = InvoicedItem(
                itemsByProductId.first,
                itemsByProductId.second.size,
                itemsByProductId.second.totalPrice()
            )
        }

        fun matches(productId: ProductId) = this.productId == productId
    }
}