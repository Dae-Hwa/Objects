package ch04.v01

import ch02.v1.Money

class Reservation(
    var customer: Customer,
    var screening: Screening,
    var fee: Money,
    var audienceCount: Int
) {
}