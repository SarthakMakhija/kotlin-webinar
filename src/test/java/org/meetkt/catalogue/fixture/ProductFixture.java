package org.meetkt.catalogue.fixture;

import org.meetkt.catalogue.domain.model.Product;
import org.meetkt.catalogue.domain.model.ProductId;
import org.meetkt.basket.domain.model.Price;

public class ProductFixture {

    private String barcode = "ZZZZZZZ";
    private ProductId productId;
    private Price price = Price.ZERO;
    private String description = "Default description";

    private ProductFixture() {
    }

    public static ProductFixture aProduct() {
        return new ProductFixture();
    }

    public ProductFixture withBarcode(String barcode) {
        this.barcode = barcode;
        return this;
    }

    public ProductFixture withProductId(String productId) {
        this.productId = new ProductId(productId);
        return this;
    }

    public ProductFixture withPriceInt(int price) {
        this.price = new Price(price);
        return this;
    }

    public ProductFixture withPriceDouble(double price) {
        this.price = new Price(price);
        return this;
    }

    public ProductFixture withDescription(String description) {
        this.description = description;
        return this;
    }

    public Product build() {
        return new Product(productId, barcode, price, description);
    }
}
