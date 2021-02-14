package org.meetkt.catalogue.exception;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class NoItemFoundForBarcodeExceptionUnitTest {

    @Test
    void shouldReturnAnExceptionMessage() {
        NoItemFoundForBarcodeException exception = new NoItemFoundForBarcodeException("test-barcode");
        assertThat(exception.getMessage()).isEqualTo("No item found for test-barcode");
    }
}