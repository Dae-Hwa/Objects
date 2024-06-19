package ch02.v1

import java.math.BigDecimal

class Money(
    private val amount: BigDecimal,
) {

    companion object {
        val ZERO = Money(BigDecimal.ZERO)

        fun wons(amount: Long): Money {
            return Money(BigDecimal.valueOf(amount))
        }

        fun wons(amount: Double): Money {
            return Money(BigDecimal.valueOf(amount))
        }
    }

    operator fun plus(amount: Money): Money {
        return Money(this.amount + amount.amount)
    }

    operator fun minus(amount: Money): Money {
        return Money(this.amount - amount.amount)
    }

    operator fun times(percent: Double): Money {
        return Money(this.amount * BigDecimal.valueOf(percent))
    }

    fun isLessThan(other: Money): Boolean {
        return amount < other.amount
    }

    fun isGreaterThanOrEqual(other: Money): Boolean {
        return amount >= other.amount
    }
}
