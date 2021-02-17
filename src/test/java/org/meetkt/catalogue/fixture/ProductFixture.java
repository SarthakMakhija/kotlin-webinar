package org.meetkt.catalogue.fixture;

import org.meetkt.catalogue.domain.model.Product;
import org.meetkt.catalogue.domain.model.ProductId;

public class ProductFixture {

    private String barcode = "ZZZZZZZ";
    private ProductId productId;
    private int price;

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

    public ProductFixture withProductPrice(int price) {
        this.price = price;
        return this;
    }

    public Product build() {
        return new Product(productId, barcode, price);
    }
}
