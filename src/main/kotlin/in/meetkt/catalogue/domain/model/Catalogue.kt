package `in`.meetkt.catalogue.domain.model

class Catalogue(products: List<Product>) {

    private val productByBarcode: Map<String, Product> = products.map { it.barcode to it }.toMap()

    //TODO: Return Option from Arrow
    fun productWith(barcode: String): Product? = productByBarcode[barcode]
}