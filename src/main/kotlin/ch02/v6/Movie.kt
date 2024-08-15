package ch02.v6

import ch02.v2.DiscountPolicy
import ch02.v2.Money
import ch02.v2.Screening
import java.time.Duration

class Movie(
    private val title: String,
    private val runningTime: Duration,
    private val fee: Money,

    private var discountPolicy: DiscountPolicy
) {
    /**
     * 이렇게 하면 실행 시점(런타임)에 할인 정책을 변경할 수 있다.
     * 상속은 컴파일 타임에 어떤 것을 사용할지 정해지므로 이런 식의 동작이 불가능하다.
     */
    fun changeDiscountPolicy(discountPolicy: DiscountPolicy) {
        this.discountPolicy = discountPolicy
    }

    fun getFee(): Money {
        return fee
    }

    fun calculateMovieFee(screening: Screening): Money {
        return fee - discountPolicy.calculateDiscountAmount(screening)
    }
}
