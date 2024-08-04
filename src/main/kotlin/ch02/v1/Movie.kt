package ch02.v1

import java.time.Duration

class Movie(
    private val title: String,
    private val runningTime: Duration,
    private val fee: Money,
    /**
     * Movie는 DiscountPolicy와 연결돼있지만, 영화 요금 계산을 위해서는 PercentDiscountPolicy 혹은 AmountDiscountPolicy의 인스턴스가 필요하다.
     *
     * 실제로 실행 시 Movie는 PercentDiscountPolicy 혹은 AmountDiscountPolicy의 인스턴스에 의존하지만, 코드 수준에서는 DiscountPolicy에만 의존한다.
     *
     * 클래스 사이의 의존성과 객체 사이의 의존성은 다를 수 있다.
     *
     */
    private val discountPolicy: DiscountPolicy
) {
    fun getFee(): Money {
        return fee
    }

    /**
     * 예매 요금을 계산하기 위해서는 현재 영화에 적용돼 있는 할인 정책의 종류를 판단할 수 있어야 한다.
     *
     * 하지만 이 메서드에는 어떤 할인 정책을 사용할 것인지 결정하는 코드가 없다. discountPolicy에게 할인 요금을 계산하라는 메세지만 전송한다.
     *
     * 이것이 어색하면 아직 객체지향 패러다임에 익숙하지 않은 것
     *
     */
    fun calculateMovieFee(screening: Screening): Money {
        /**
         * Movie 클래스에는 할인 정책이 어떤 것인지 판단하는 조건문이 없음에도 할인 정책을 선택해 넣을 수 있다.
         *
         * 이는 상속과 다형성 때문이다. 그리고 discountPolicy가 추상화 되어 있기 때문이다.
         *
         * 메세지와 메소드는 다른 개념이다. 실행되는 메서드는 객체의 클래스가 뭔지에 따라 달라진다.
         *
         * PercentDiscountPolicy의 인스턴스가 연결되면 PercentDiscountPolicy가 오버라이딩한 calculateDiscountAmount 메서드가 실행된다.
         *
         * 이처럼 어떤 메서드가 실행될 것인지는 메세지를 수신하는 객체의 클래스가 무엇이냐에 따라 달라진다. 이를 다형성이라고 한다.
         */
        return fee - discountPolicy.calculateDiscountAmount(screening)
    }
}
