package `in`.meetkt.display.domain.model

import `in`.meetkt.basket.domain.model.Basket
import `in`.meetkt.basket.domain.model.Items
import `in`.meetkt.basket.domain.model.Price

class Display(private val basket: Basket) {

    fun totalBasketPrice(): Price = basket.totalPrice()

    fun allBasketItems(): Items = basket.allItems()

    //TODO: Implement this
    // public Invoice invoice() {
    //        return Invoice.of(basket);
    //    }
}