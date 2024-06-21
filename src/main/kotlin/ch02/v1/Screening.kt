package ch02.v1

import java.time.LocalDateTime

class Screening(
    private val movie: Movie,
    private val sequence: Int,
    private val whenScreened: LocalDateTime
) {
    fun isSequence(sequence: Int): Boolean {
        return this.sequence == sequence
    }

    fun getMovieFee(): Money {
        return movie.getFee()
    }
}