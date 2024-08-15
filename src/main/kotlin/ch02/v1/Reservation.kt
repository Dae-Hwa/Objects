package ch02.v1

class Reservation(
    val customer: Customer,
    val screening: Screening,
    val fee: Money,
    val audienceCount: Int
)
