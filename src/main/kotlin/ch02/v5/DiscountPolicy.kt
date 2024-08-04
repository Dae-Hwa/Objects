package ch02.v5

import ch02.v1.Money
import ch02.v1.Screening

interface DiscountPolicy {
    fun calculateDiscountAmount(screening: Screening): Money
}