package ch02.v1

import java.time.DayOfWeek
import java.time.LocalTime

/**
 * 영화 예매 시스템에는 순번 조건과 기간 조건의 두 가지 할인 조건이 존재한다.
 * 각각 SequenceCondition과 PeriodCondition 클래스로 구현한다.
 */
interface DiscountCondition {
    // TMI - 옛날에는 이게 안 돼서 어댑터를 많이 썼다.
    // 스프링 옛날 버전에서 최신 버전으로 업그레이드 할 때,
    // xxxAdapter 가 Deprecated 되어서 xxx 를 그대로 쓰도록 수정하는 경우가 여기에 해당
    fun isSatisfiedBy(screening: Screening): Boolean {
        return false
    }
}

class SequenceCondition(
    private val sequence: Int
) : DiscountCondition {
    /**
     * 매개변수로 전달된 Screening의 상영 순번이 할인 조건의 순번과 일치하는지 검사한다.
     */
    override fun isSatisfiedBy(screening: Screening): Boolean {
        return screening.isSequence(sequence)
    }
}

class PeriodCondition(
    private val dayOfWeek: DayOfWeek,
    private val startTime: LocalTime,
    private val endTime: LocalTime
) : DiscountCondition {
    /**
     * 매개변수로 전달된 Screening의 요일과 상영 시간이 할인 조건의 요일과 시간 범위에 포함되는지 검사한다.
     */
    override fun isSatisfiedBy(screening: Screening): Boolean {
        return screening.getStartTime().dayOfWeek == dayOfWeek &&
                startTime <= screening.getStartTime().toLocalTime() &&
                endTime >= screening.getStartTime().toLocalTime()
    }
}