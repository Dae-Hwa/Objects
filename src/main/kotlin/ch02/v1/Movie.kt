package ch02.v1

class Movie(
    private val title: String,
    private val runningTime: Duration,
    private val fee: Money,
    private val discountConditions: List<DiscountCondition>
) {
    fun getFee(): Money {

    }

}
