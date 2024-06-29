package ch02.v5

import ch02.v2.Money
import ch02.v2.Screening

interface DiscountPolicy {
    fun calculateDiscountAmount(screening: Screening): Money
}