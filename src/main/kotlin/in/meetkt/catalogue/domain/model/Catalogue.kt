package `in`.meetkt.catalogue.domain.model

import arrow.core.Option

class Catalogue(products: List<Product>) {

    private val productByBarcode: Map<String, Product> = products.map { it.barcode to it }.toMap()

    fun productWith(barcode: String): Option<Product> = Option.fromNullable(productByBarcode[barcode])
}
