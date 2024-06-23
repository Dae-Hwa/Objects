package ch02.v2

import java.time.DayOfWeek
import java.time.Duration
import java.time.LocalDateTime
import java.time.LocalTime

class Example {

    companion object {
        fun avatar() {
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
            val screening = Screening(
                avatar,
                1,
                LocalDateTime.of(2021, 7, 1, 10, 0)
            )
            val customer = Customer("박재성", "010-1234-5678")
            val reservation = screening.reserve(customer, 2)
            println(reservation)
        }

        fun titanic() {
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
    }
}