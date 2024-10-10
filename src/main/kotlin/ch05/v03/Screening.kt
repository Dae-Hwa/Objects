package ch05.v03

import ch02.v1.Money
import ch04.v01.Customer
import java.time.LocalDateTime

/**
 * 1. 책임결정
 * 영화를 예매한다.
 *
 * - 예매에 대한 정보 전문가
 * - Reservation 객체 생성
 *
 */
class Screening(
    /**
     * 2. 책임 수행에 필요한 인스턴스 변수 결정
     */
    private val movie: Movie,
    /**
     * 11. 협업을 위한 getter 제공
     */
    val sequence: Int,
    val whenScreened: LocalDateTime
) {
    /**
     * 1. 책임 결정
     * 예매하라 메세지에 응답할 수 있어야 함
     */
    fun reserve(customer: Customer, audienceCount: Int) {
        /**
         * 4. Reservation 객체 생성
         */
        val reservation = Reservation(customer, this, calculateFee(audienceCount), audienceCount)
    }

    private fun calculateFee(audienceCount: Int): Money {
        /**
         * 3. 어떤 메세지 전송할건지 결정
         */
        return movie.calculateMovieFee(this).times(audienceCount)
    }
}