package `in`.meetkt.basket.domain.model

data class Price(private val value: Double) {

    fun add(other: Price): Price {
        return Price(value + other.value)
    }

    companion object {
        val ZERO = Price(0.0)
    }
}