package org.meetkt.invoice.domain.model;

import org.meetkt.basket.domain.model.Basket;
import org.meetkt.basket.domain.model.Item;
import org.meetkt.basket.domain.model.Items;
import org.meetkt.catalogue.domain.model.ProductId;
import org.meetkt.display.domain.model.Price;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;
import java.util.stream.Collectors;

public class Invoice {

    private final InvoicedItems invoicedItems;

    private Invoice(Basket basket) {
        this.invoicedItems = new InvoicedItems(basket.allItems());
    }

    public static Invoice of(Basket basket) {
        return new Invoice(basket);
    }

    public int totalItems() {
        return invoicedItems.totalItems();
    }

    public Price totalPrice() {
        return invoicedItems.totalPrice();
    }

    public int totalItemsFor(ProductId productId) {
        return invoicedItems.totalItemsFor(productId);
    }
}

class InvoicedItems extends ArrayList<InvoicedItems.InvoicedItem> {

    public InvoicedItems(Items items) {
        super(items
                .stream()
                .collect(Collectors.groupingBy(
                        Item::productId,
                        Collectors.toCollection(() -> new Items(Collections.emptyList()))
                        )
                )
                .entrySet()
                .stream()
                .map(InvoicedItem::new)
                .collect(Collectors.toList())
        );
    }

    public int totalItems() {
        return this.stream().map(InvoicedItem::quantity).reduce(0, Integer::sum);
    }

    public Price totalPrice() {
        return this.stream().map(InvoicedItem::totalPrice).reduce(Price.ZERO, (Price::add));
    }

    public int totalItemsFor(ProductId productId) {
        return this.stream().filter(invoicedItem -> invoicedItem.matches(productId)).map(InvoicedItem::quantity).reduce(0, Integer::sum);
    }

    static class InvoicedItem {

        private final ProductId productId;
        private final int quantity;
        private final Price totalPrice;

        public InvoicedItem(Map.Entry<ProductId, Items> productIdItemsEntry) {
            this.productId = productIdItemsEntry.getKey();
            this.quantity = productIdItemsEntry.getValue().size();
            this.totalPrice = productIdItemsEntry.getValue().totalPrice();
        }

        public boolean matches(ProductId productId) {
            return this.productId.equals(productId);
        }

        public int quantity() {
            return quantity;
        }

        public Price totalPrice() {
            return totalPrice;
        }
    }
}

