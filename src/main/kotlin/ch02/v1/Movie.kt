package ch02.v1

import ch02.v2.DiscountPolicy
import java.time.Duration

class Movie(
    private val title: String,
    private val runningTime: Duration,
    private val fee: Money,
    private val discountPolicy: DiscountPolicy
) {
    fun getFee(): Money {
        return fee
    }

    fun calculateMovieFee(screening: Screening): Money {
        TODO("Not yet implemented")
    }

}
