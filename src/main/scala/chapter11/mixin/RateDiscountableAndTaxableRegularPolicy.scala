import java.time.Duration

class RateDiscountableAndTaxableRegularPolicy(amount: Money, seconds: Duration, val discountAmount: Money, val taxRate: Double) extends RegularPolicy(amount, seconds) with RateDiscountablePolicy with TaxablePolicy
