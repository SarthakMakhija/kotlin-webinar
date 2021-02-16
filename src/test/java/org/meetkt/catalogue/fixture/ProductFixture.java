package org.meetkt.catalogue.fixture;

import org.meetkt.catalogue.domain.model.Product;

public class ProductFixture {

    private String barcode = "ZZZZZZZ";
    private String productId;

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
        this.productId = productId;
        return this;
    }

    public Product build() {
        return new Product(productId, barcode);
    }
}
