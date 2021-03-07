package `in`.meetkt.catalogue

import `in`.meetkt.catalogue.domain.model.Catalogue
import `in`.meetkt.catalogue.domain.model.Product
import `in`.meetkt.catalogue.exception.NoProductFoundForBarcodeException
import arrow.core.Either

class BarcodeScanner(private val catalogue: Catalogue) {

    //TODO: Introduce sealed class
    fun scanOrThrow(barcode: String): Either<NoProductFoundForBarcodeException, Product> {
        val product: Product? = catalogue.productWith(barcode)

        return if (product == null)
            Either.Left(NoProductFoundForBarcodeException(barcode))
        else
            Either.Right(product)
    }
}
