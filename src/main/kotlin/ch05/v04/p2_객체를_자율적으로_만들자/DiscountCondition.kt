package ch05.v04.p2_객체를_자율적으로_만들자

import ch04.v01.DiscountConditionType
import java.time.DayOfWeek
import java.time.LocalTime

class DiscountCondition(
    private val type: DiscountConditionType,
    private val sequence: Int,
    private val dayOfWeek: DayOfWeek,
    private val startTime: LocalTime,
    private val endTime: LocalTime
) {
    fun isDiscountable(screening: Screening): Boolean {
        if (type == DiscountConditionType.PERIOD) {
            return isSatisfiedByPeriod(screening)
        }

        return isSatisfiedBySequence(screening)
    }

    private fun isSatisfiedByPeriod(screening: Screening): Boolean {
        return dayOfWeek == screening.whenScreened.dayOfWeek &&
               startTime >= screening.whenScreened.toLocalTime() &&
               endTime <= screening.whenScreened.toLocalTime()
    }

    private fun isSatisfiedBySequence(screening: Screening): Boolean {
        return sequence == screening.sequence
    }
}