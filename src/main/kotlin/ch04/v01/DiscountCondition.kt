package ch04.v01

import java.time.DayOfWeek
import java.time.LocalTime

class DiscountCondition(
    var type: DiscountConditionType,
    var sequence: Int,
    var dayOfWeek: DayOfWeek,
    var startTime: LocalTime,
    var endTime: LocalTime
) {
}