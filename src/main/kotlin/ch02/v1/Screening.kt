package ch02.v1

class Screening(
    private val movie: Movie,
    private val sequence: Int,
    private val whenScreened: Long
) {

    fun calculateFee(audienceCount: Int): Money {
        return movie.calculateMovieFee(this) * (audienceCount)
    }

    fun reserve(customer: Customer, audienceCount: Int): Reservation {
        return Reservation(customer, this, calculateFee(audienceCount), audienceCount)
    }

    fun getStartTime() = whenScreened

    fun isSequence(sequence: Int) = this.sequence == sequence

    fun getMovieFee() = movie.getFee()
}