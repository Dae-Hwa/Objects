package ch02.v2

import java.time.Duration

class Movie(
    private val title: String,
    private val runningTime: Duration,
    private val fee: Money,
    /**
     * 영화는 하나의 할인 정책만 적용할 수 있다.
     */
    private val discountPolicy: DiscountPolicy
) {
    fun getFee(): Money {
        return fee
    }

    /**
     * 예매 요금을 계산하기 위해서는 현재 영화에 적용돼 있는 할인 정책의 종류를 판단할 수 있어야 한다.
     * 하지만 이 메서드에는 어떤 할인 정책을 사용할 것인지 결정하는 코드가 없다. discountPolicy에게 할인 요금을 계산하라는 메세지만 전송한다.
     * 이것이 어색하면 아직 객체지향 패러다임에 익숙하지 않은 것
     */
    fun calculateMovieFee(screening: Screening): Money {
        // 이 코드에는 상속과 다형성의 개념이 숨겨져 있다. 그 기반에는 추상화라는 원리가 숨겨져 있다.
        return fee - discountPolicy.calculateDiscountAmount(screening)
    }
}
