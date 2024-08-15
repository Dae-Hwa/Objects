package ch02.v1

import java.time.LocalDateTime

class Screening(
    private val movie: Movie,
    private val sequence: Int,
    private val whenScreened: LocalDateTime
) {

    /**
     * creening이 Movie의 calculateFee 메소드를 호출한다고 하는 것 보다 Screening이 Movie에게 calculateFee 메세지를 전송한다고 하는 것이 더 적절한 표현이다.
     *
     * Screening은 Movie 안에 calculateFee 메소드가 존재하고 있는지도 알지 못한다. 응답할 수 있다고 믿고 메세지를 전송하는 것이다.
     *
     * 메세지를 수신받은 Movie는 적절한 메서드를 선택한다. 방법을 선택하는 것은 Movie 스스로의 문제다. 메세지를 처리하는 방법을 자율적으로 결정할 수 있는 이유다.
     */
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