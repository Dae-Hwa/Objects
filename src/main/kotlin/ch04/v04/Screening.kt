package ch04.v04

import ch02.v1.Money
import ch04.v01.MovieType
import java.time.LocalDateTime

class Screening(
    private val movie: Movie,
    private val sequence: Int,
    private val whenScreened: LocalDateTime
) {

    fun calculateFee(audienceCount: Int): Money {
        when (movie.movieType) {
            MovieType.AMOUNT_DISCOUNT -> {
                if (movie.isDiscountable(whenScreened, sequence)) {
                    return movie.calculateAmountDiscountedFee() * audienceCount
                }
            }

            MovieType.PERCENT_DISCOUNT -> {
                if (movie.isDiscountable(whenScreened, sequence)) {
                    return movie.calculatePercentDiscountedFee() * audienceCount
                }
            }

            MovieType.NONE_DISCOUNT -> {
                return movie.calculateNoneDiscountedFee() * audienceCount
            }
        }

        return movie.calculateNoneDiscountedFee() * audienceCount
    }
}