package `in`.meetkt.catalogue.exception

class NoProductFoundForBarcodeException(barcode: String) : RuntimeException("No product found for $barcode")