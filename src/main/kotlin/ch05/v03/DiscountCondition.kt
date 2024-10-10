package ch05.v03

import ch04.v01.DiscountConditionType
import java.time.DayOfWeek
import java.time.LocalTime

class DiscountCondition(
    /**
     * 9. 메세지 처리에 필요한 인스턴스 변수 선언
     */
    private val type: DiscountConditionType,
    private val sequence: Int,
    private val dayOfWeek: DayOfWeek,
    private val startTime: LocalTime,
    private val endTime: LocalTime
) {
    /**
     * 8. 메세지 전송 받을 수 있는 메서드 구현
     */
    fun isSatisfiedBy(screening: Screening): Boolean {
        /**
         * 10. 메세지 처리 방법 구현
         */
        if (type == DiscountConditionType.PERIOD) {
            return isSatisfiedByPeriod(screening)
        }

        return isSatisfiedBySequence(screening)
    }


    private fun isSatisfiedByPeriod(screening: Screening): Boolean {
        return dayOfWeek == screening.whenScreened.dayOfWeek &&
                startTime <= screening.whenScreened.toLocalTime() &&
                endTime >= screening.whenScreened.toLocalTime()
    }

    private fun isSatisfiedBySequence(screening: Screening): Boolean {
        return sequence == screening.sequence
    }
}