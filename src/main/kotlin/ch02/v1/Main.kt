package ch02.v1

import ch02.v4.NoneDiscountPolicy
import java.time.DayOfWeek
import java.time.Duration
import java.time.LocalDateTime
import java.time.LocalTime

class Main {

}

fun main() {
    // 생성자에 필요한 정보를 전달하도록 강제하면 올바른 상태를 가진 객체 생성을 보장할 수 있다.
    val avatar = Movie(
        "아바타",
        Duration.ofMinutes(120),
        Money.wons(10000),
        AmountDiscountPolicy(
            Money.wons(800),
            SequenceCondition(1),
            SequenceCondition(10),
            PeriodCondition(
                DayOfWeek.MONDAY,
                LocalTime.of(10, 0),
                LocalTime.of(11, 59)
            ),
            PeriodCondition(
                DayOfWeek.TUESDAY,
                LocalTime.of(10, 0),
                LocalTime.of(20, 59)
            )
        )
    )

    val titanic = Movie(
        "타이타닉",
        Duration.ofMinutes(180),
        Money.wons(11000),
        PercentDiscountPolicy(
            0.1,
            PeriodCondition(
                DayOfWeek.TUESDAY,
                LocalTime.of(14, 0),
                LocalTime.of(16, 59)
            ),
            SequenceCondition(2),
            PeriodCondition(
                DayOfWeek.THURSDAY,
                LocalTime.of(10, 0),
                LocalTime.of(13, 59)
            )
        )
    )
}