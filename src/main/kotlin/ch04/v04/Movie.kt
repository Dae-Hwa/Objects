package ch04.v04

import ch02.v1.Money
import ch04.v01.DiscountConditionType
import ch04.v01.MovieType
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.LocalTime
import kotlin.time.Duration

class Movie(
    private val title: String,
    private val runningTime: Duration,
    private val fee: Money,
    private val discountConditions: List<DiscountCondition>,

    val movieType: MovieType,
    private val discountAmount: Money,
    private val discountPercent: Double
) {
    fun calculateAmountDiscountedFee(): Money {
        if (movieType != MovieType.AMOUNT_DISCOUNT) {
            throw IllegalArgumentException()
        }
        return fee.minus(discountAmount)
    }

    fun calculatePercentDiscountedFee(): Money {
        if (movieType != MovieType.PERCENT_DISCOUNT) {
            throw IllegalArgumentException()
        }
        return fee.minus(fee.times(discountPercent))
    }

    fun calculateNoneDiscountedFee(): Money {
        if (movieType != MovieType.NONE_DISCOUNT) {
            throw IllegalArgumentException()
        }
        return fee
    }

    fun isDiscountable(whenScreened: LocalDateTime, sequence: Int): Boolean {
        // discountConditions 훑어 가면서 할인 조건 타입 체크
        for (condition in discountConditions) {
            if (condition.type == DiscountConditionType.PERIOD) {
                // 조건이 기간 조건이면 기간이 매개변수인 할인 판단 메서드 호출
                if (condition.isDiscountable(whenScreened.dayOfWeek, whenScreened.toLocalTime())) {
                    return true
                }
            } else {
                // 순번 조건이면 순번이 매개변수인 할인 판단 메서드 호출
                if (condition.isDiscountable(sequence)) {
                    return true
                }
            }
        }

        return false
    }
}