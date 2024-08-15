package ch02.v4

import ch02.v1.Customer
import ch02.v1.Money
import ch02.v1.Movie
import ch02.v1.Screening
import java.time.Duration
import java.time.LocalDateTime

class Example {

    companion object {
        fun starwars() {
            val starwars = Movie(
                "스타워즈",
                Duration.ofMinutes(210),
                Money.wons(10000),
                NoneDiscountPolicy()
            )
            val screening = Screening(
                starwars,
                1,
                LocalDateTime.of(2021, 7, 1, 10, 0)
            )
            val customer = Customer("박재성", "010-1234-5678")
            val reservation = screening.reserve(customer, 2)
            println(reservation)
        }
    }
}