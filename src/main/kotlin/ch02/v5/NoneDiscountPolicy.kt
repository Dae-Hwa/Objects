package ch02.v5

import ch02.v1.Money
import ch02.v1.Screening

/**
 * 기존 DiscountPolicy를 DefaultDiscountPolicy로 변경하고 상위에 DiscountPolicy 인터페이스를 만들어 상속받을 수 있도록 했다.
 * 이렇게하면 DiscountPolicy와 개념적으로 결합되어있던 문제를 해결할 수 있다.
 * > 기존 DiscountPolicy의 코드 흐름 상 조건이 없으면 항상 Mony.ZERO 를 반환하기 때문
 */
class NoneDiscountPolicy : DiscountPolicy {
    override fun calculateDiscountAmount(screening: Screening): Money {
        return Money.ZERO
    }
}