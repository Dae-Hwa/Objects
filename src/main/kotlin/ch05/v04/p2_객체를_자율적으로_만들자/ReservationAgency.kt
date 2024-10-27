package ch05.v04.p2_객체를_자율적으로_만들자

import ch02.v1.Money
import ch04.v01.Customer
import ch04.v01.MovieType

class ReservationAgency {

    fun reserve(
        screening: Screening,
        customer: Customer,
        audienceCount: Int
    ): Reservation {
        val discountable = checkDiscountable(screening)
        val fee = calculateFee(screening, discountable, audienceCount)
        return createReservation(customer, screening, fee, audienceCount)
    }

    private fun checkDiscountable(screening: Screening): Boolean {
        return screening.movie.discountConditions.any { condition -> condition.isDiscountable(screening) }
    }


    private fun calculateFee(screening: Screening, discountable: Boolean, audienceCount: Int): Money {
        val movie = screening.movie
        return if (discountable) {
            (movie.fee - calculateDiscountFee(movie)) * audienceCount
        } else {
            movie.fee
        }
    }

    private fun calculateDiscountFee(movie: Movie): Money {
        return when (movie.movieType) {
            MovieType.AMOUNT_DISCOUNT -> calculateAmountDiscountAmount(movie)
            MovieType.PERCENT_DISCOUNT -> calculatePercentDiscountAmount(movie)
            MovieType.NONE_DISCOUNT -> calculateNoneDiscountAmount()
        }
    }

    private fun calculateAmountDiscountAmount(movie: Movie): Money {
        return movie.discountAmount
    }

    private fun calculatePercentDiscountAmount(movie: Movie): Money {
        return movie.fee * movie.discountPercent
    }

    private fun calculateNoneDiscountAmount(): Money {
        return Money.ZERO
    }

    private fun createReservation(
        customer: Customer,
        screening: Screening,
        fee: Money,
        audienceCount: Int
    ): Reservation {
        return Reservation(customer, screening, fee, audienceCount)
    }
}
