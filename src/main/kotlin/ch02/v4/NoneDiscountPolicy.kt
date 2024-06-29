package ch02.v4

import ch02.v2.DiscountPolicy
import ch02.v2.Money
import ch02.v2.Screening

/**
 * 0원이라는 할인 요금을 계산할 책임을 DiscountPolicy 계층에 위임한다.
 * 기존의 Movie와 DiscountPolicy는 수정하지 않고 NoneDiscountPolicy 만을 추가하여 기능을 확장했다.
 */
class NoneDiscountPolicy : DiscountPolicy(emptyList()) {
    override fun getDiscountAmount(screening: Screening): Money {
        return Money.ZERO
    }
}