package `in`.meetkt.catalogue

import `in`.meetkt.catalogue.domain.model.Catalogue
import `in`.meetkt.catalogue.domain.model.Product
import `in`.meetkt.catalogue.exception.NoProductFoundForBarcodeException

class BarcodeScanner(private val catalogue: Catalogue) {

    fun scanOrThrow(barcode: String): Product {
        val product: Product? = catalogue.productWith(barcode)
        return product ?: throw NoProductFoundForBarcodeException(barcode)
    }
}