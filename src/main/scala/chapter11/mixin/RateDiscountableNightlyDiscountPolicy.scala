import java.time.Duration

class RateDiscountableNightlyDiscountPolicy(nightlyAmount: Money, regularAmount: Money, seconds: Duration, val discountAmount: Money) extends NightlyDiscountPolicy(nightlyAmount, regularAmount, seconds) with RateDiscountablePolicy