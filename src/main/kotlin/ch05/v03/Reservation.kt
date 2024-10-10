package ch05.v03

import ch02.v1.Money
import ch04.v01.Customer

class Reservation(
    var customer: Customer,
    var screening: Screening,
    var fee: Money,
    var audienceCount: Int
) {
}