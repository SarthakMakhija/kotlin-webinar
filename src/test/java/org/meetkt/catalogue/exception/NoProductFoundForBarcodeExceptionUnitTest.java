package org.meetkt.catalogue.exception;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class NoProductFoundForBarcodeExceptionUnitTest {

    @Test
    void shouldReturnAnExceptionMessage() {
        NoProductFoundForBarcodeException exception = new NoProductFoundForBarcodeException("test-barcode");
        assertThat(exception.getMessage()).isEqualTo("No product found for test-barcode");
    }
}