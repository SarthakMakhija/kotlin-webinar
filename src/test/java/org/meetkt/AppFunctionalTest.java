package org.meetkt;

import org.junit.jupiter.api.Test;
import org.meetkt.basket.domain.model.Basket;
import org.meetkt.catalogue.domain.model.Price;
import org.meetkt.catalogue.BarcodeScanner;
import org.meetkt.catalogue.domain.model.Catalogue;
import org.meetkt.invoice.domain.model.Invoice;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.meetkt.catalogue.fixture.ProductFixture.aProduct;

public class AppFunctionalTest {

    @Test
    void shouldGenerateAnInvoiceForABasket() {
        Catalogue catalogue = new Catalogue(
                List.of(
                        aProduct().withProductId("P-100").withBarcode("B-100").withPriceInt(100).build(),
                        aProduct().withProductId("P-200").withBarcode("B-200").withPriceInt(200).build()
                )
        );

        BarcodeScanner barcodeScanner = new BarcodeScanner(catalogue);

        Basket basket = Basket.empty();
        basket.add(barcodeScanner.scanOrThrow("B-100"));
        basket.add(barcodeScanner.scanOrThrow("B-200"));

        Invoice invoice = Invoice.of(basket);

        assertThat(invoice.totalItems()).isEqualTo(2);
        assertThat(invoice.totalPrice()).isEqualTo(new Price(300));
    }
}
