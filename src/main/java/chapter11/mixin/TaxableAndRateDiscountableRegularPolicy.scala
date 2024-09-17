package chapter11.mixin

import java.time.Duration

class TaxableAndRateDiscountableRegularPolicy(amount: Money, seconds: Duration, val discountAmount: Money, val taxRate: Double) extends RegularPolicy(amount, seconds) with TaxablePolicy with RateDiscountablePolicy
