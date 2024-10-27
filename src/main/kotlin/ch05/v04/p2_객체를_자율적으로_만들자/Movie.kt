package ch05.v04.p2_객체를_자율적으로_만들자

import ch02.v1.Money
import ch04.v01.MovieType
import java.time.Duration

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