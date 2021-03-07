package `in`.meetkt.catalogue

import `in`.meetkt.catalogue.domain.model.Catalogue
import `in`.meetkt.catalogue.domain.model.Product
import `in`.meetkt.catalogue.exception.NoProductFoundForBarcodeException
import arrow.core.Either

class BarcodeScanner(private val catalogue: Catalogue) {

    fun scanOrThrow(barcode: String): Either<NoProductFoundForBarcodeException, Product> {
        return catalogue
                .productWith(barcode)
                .toEither { NoProductFoundForBarcodeException(barcode) }
    }
}
