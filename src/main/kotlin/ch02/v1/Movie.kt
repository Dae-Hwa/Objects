package ch02.v1

class Movie(
    private val fee: Money
) {
    fun getFee(): Money {
        return fee
    }
}
