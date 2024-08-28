package ch04.v01

import ch02.v1.Money

class ReservationAgency {

    /**
     * reserve 메소드는 크게 두 부분으로 나뉜다.
     * 1. 할인 가능여부를 확인하는 for문
     * 2. 할인 정책에 따라 요금을 계산하는 if문
     */
    fun reserve(
        screening: Screening,
        customer: Customer,
        audienceCount: Int
    ): Reservation {
        val movie = screening.movie

        var discountable = false;
        for (condition in movie.discountConditions) {
            if (condition.type == DiscountConditionType.PERIOD) {
                discountable = screening.whenScreened.dayOfWeek == condition.dayOfWeek &&
                        condition.startTime >= screening.whenScreened.toLocalTime() &&
                        condition.endTime <= screening.whenScreened.toLocalTime()
            } else {
                discountable = condition.sequence == screening.sequence
            }
            if (discountable) {
                break
            }
        }

        val fee: Money
        if (discountable) {
            var discountAmount = Money.ZERO
            when (movie.movieType) {
                MovieType.AMOUNT_DISCOUNT -> discountAmount = movie.discountAmount
                MovieType.PERCENT_DISCOUNT -> discountAmount = movie.fee.times(movie.discountPercent)
                MovieType.NONE_DISCOUNT -> discountAmount = Money.ZERO
            }
            fee = movie.fee - discountAmount
        } else {
            fee = movie.fee
        }

        return Reservation(customer, screening, fee, audienceCount)
    }
}