package ch04.v01

import ch02.v1.Money
import java.time.Duration

/**
 * 데이터 중심 설계 예시
 *
 * 나름의 캡슐화를 위해 접근자와 수정자를 만들어둔다. 속성을 외부에 노출하면 안 되니까
 */
class Movie(
    var title:String,
    var runningTime:Duration,
    var fee: Money,
    // DiscountPolicy가 아니라 Movie의 인스턴스 변수에 포함된다
    var discountConditions: List<DiscountCondition>,

    /*
     * discountAmount와 discountPercent중에 뭘 사용할지 구분을 위해 MovieType을 사용한다.
     */
    var movieType: MovieType,
    /*
     * discountPolicy를 결정할 조건들이 Movie에 정의돼있다.
     */
    var discountAmount: Money,
    var discountPercent: Double
) {

}