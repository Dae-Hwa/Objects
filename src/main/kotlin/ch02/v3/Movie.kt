package ch02.v3

import ch02.v1.DiscountPolicy
import ch02.v1.Money
import ch02.v1.Screening
import java.time.Duration

class Movie(
    private val title: String,
    private val runningTime: Duration,
    private val fee: Money,
     // 코틀린이라 DiscountPolicy도 Nullable로 바뀌었다.
    private val discountPolicy: DiscountPolicy?
) {
    fun getFee(): Money {
        return fee
    }

    /**
     * 할인 정책이 적용돼있지 않으면 요금 계산 필요 없이 기본 금액을 그대로 사용해도 되는데,
     *
     * 이 방식의 문제점은 할인 정책이 없는 경우가 예외 케이스로 취급되기 때문에 지금까지 일관성 있던 협력 방식이 무너진다는 것이다.
     *
     * - 할인 금액 계산 책임이 DiscountPolicy가 아니라 Movie에 있다.
     *
     * 책임의 위치를 결정하기 위해 조건문을 사용하는 것은 협력의 설계 측면에서 대부분 좋지 않은 선택이다.
     *
     * 항상 예외 케이스를 최소화하고 일관성을 유지할 수 있는 방법을 선택해야 한다.
     */
    fun calculateMovieFee(screening: Screening): Money {
        if (discountPolicy == null) {
            return fee
        }

        return fee - discountPolicy.calculateDiscountAmount(screening)
    }
}
