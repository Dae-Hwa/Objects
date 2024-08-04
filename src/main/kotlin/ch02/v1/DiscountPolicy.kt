package ch02.v1

/**
 * 할인 정책은 금액 할인 정책과 비율 할인 정책으로 구분된다.
 * 대부분의 코드는 유사하고 할인 요금을 계산하는 방식만 다르므로 부모 클래스에 공통 코드를 보관한다.
 * DiscountPolicy는 인스턴스를 생성할 필요가 없기 때문에 추상 클래스로 구현했다.
 */
abstract class DiscountPolicy(
    /**
     * 할인 정책은 여러 개의 할인 조건을 포함할 수 있다.
     */
    private val conditions: List<DiscountCondition>
) {

    fun calculateDiscountAmount(screening: Screening): Money {
        conditions.forEach {
            /**
             * 하나의 할인정책은 여러개의 조건을 포함할 수 있으므로 조건을 충족하는 경우 계산 결과를 반환하도록 한다.
             */
            if (it.isSatisfiedBy(screening)) {
                return getDiscountAmount(screening)
            }
        }

        return Money.ZERO
    }

    /**
     * 부모 클래스에 기본적인 알고리즘의 흐름을 구현한다.
     * 그리고 중간에 필요한 처리를 자식 클래스에 위임한다.
     * 이러한 디자인 패턴을 템플릿 메서드 패턴이라고 한다.
     */
    protected abstract fun getDiscountAmount(screening: Screening): Money
}

class AmountDiscountPolicy(
    private val discountAmount: Money,
    conditions: List<DiscountCondition>
) : DiscountPolicy(conditions) {

    constructor(
        discountAmount: Money,
        vararg conditions: DiscountCondition
    ) : this(discountAmount, conditions.toList())

    override fun getDiscountAmount(screening: Screening): Money {
        return discountAmount
    }
}

class PercentDiscountPolicy(
    private val percent: Double,
    conditions: List<DiscountCondition>
) : DiscountPolicy(conditions) {

    constructor(
        percent: Double,
        vararg conditions: DiscountCondition
    ) : this(percent, conditions.toList())

    override fun getDiscountAmount(screening: Screening): Money {
        return screening.getMovieFee() * percent
    }
}