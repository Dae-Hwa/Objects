package ch02.v5

import ch02.v1.DiscountCondition
import ch02.v1.Money
import ch02.v1.Screening

abstract class DefaultDiscountPolicy(
    private val conditions: List<DiscountCondition>
) : DiscountPolicy {

    override fun calculateDiscountAmount(screening: Screening): Money {
        conditions.forEach {
            if (it.isSatisfiedBy(screening)) {
                return getDiscountAmount(screening)
            }
        }

        return Money.ZERO
    }

    protected abstract fun getDiscountAmount(screening: Screening): Money
}

class AmountDiscountPolicy(
    private val discountAmount: Money,
    conditions: List<DiscountCondition>
) : DefaultDiscountPolicy(conditions) {

    constructor(
        discountAmount: Money,
        vararg conditions: DiscountCondition
    ) : this(discountAmount, conditions.toList())

    override fun getDiscountAmount(screening: Screening): Money {
        return discountAmount
    }
}