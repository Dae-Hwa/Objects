package ch05.v03

import ch02.v1.Money
import ch04.v01.MovieType
import kotlin.time.Duration


class Movie(
    /**
     * 6. 메세지 처리에 필요한 인스턴스 변수 선언
     */
    private val title: String,
    private val runningTime: Duration,
    private val fee: Money,
    private val discountConditions: List<DiscountCondition>,

    private val movieType: MovieType,
    private val discountAmount: Money,
    private val discountPercent: Double
    ) {
    /**
     * 5. Screening 이 정해준 메세지 수신. Screening 은 Movie 의 내부를 모른채로 전송할 메세지를 정했으니 Movie 가 자연스럽게 캡슐화됨
     *
     * 메세지가 변경되지 않는 한 Movie에 어떤 수정을 가해도 Screening은 영향을 받지 않음
     */
    fun calculateMovieFee(screening: Screening): Money {
        /**
         * 7. 메세지 처리 방법 구현
         */
        if (isDiscountable(screening)) {
            return fee - calculateDiscountAmount()
        }

        return fee
    }

    private fun isDiscountable(screening: Screening): Boolean {
        return discountConditions.any { it.isSatisfiedBy(screening) }
    }

    private fun calculateDiscountAmount(): Money {
        return when (movieType) {
            MovieType.AMOUNT_DISCOUNT -> calculateAmountDiscountAmount()
            MovieType.PERCENT_DISCOUNT -> calculatePercentDiscountAmount()
            MovieType.NONE_DISCOUNT -> calculateNoneDiscountAmount()
        }
    }

    private fun calculateAmountDiscountAmount(): Money {
        return discountAmount
    }

    private fun calculatePercentDiscountAmount(): Money {
        return fee.times(discountPercent)
    }

    private fun calculateNoneDiscountAmount(): Money {
        return Money.ZERO
    }
}