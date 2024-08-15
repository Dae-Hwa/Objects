package ch02.v1

import java.math.BigDecimal

/**
 * 1장에서는 금액에 Long 타입을 사용했다.
 *
 * 하지만 이는 Money 타입처럼 저장하는 값이 금액과 관련돼있다는 의미를 전달할 수는 없다.
 *
 * 또한 금액과 관련된 로직이 서로 다른 곳에 중복되어 구현되는 것을 막을 수 없다.
 */
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

    operator fun times(percent: Int): Money {
        return Money(this.amount * BigDecimal.valueOf(percent.toLong()))
    }

    fun isLessThan(other: Money): Boolean {
        return amount < other.amount
    }

    fun isGreaterThanOrEqual(other: Money): Boolean {
        return amount >= other.amount
    }
}
