package `in`.meetkt.display.domain.model

import `in`.meetkt.basket.domain.model.Basket
import `in`.meetkt.basket.domain.model.Items
import `in`.meetkt.basket.domain.model.Price
import `in`.meetkt.invoice.domain.model.Invoice

class Display(private val basket: Basket) {

    fun totalBasketPrice(): Price = basket.totalPrice()

    fun allBasketItems(): Items = basket.allItems()

    fun invoice(): Invoice = Invoice.`for`(basket)
}