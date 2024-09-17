package chapter11.mixin

import java.time.Duration

class TaxableRegularPolicy(amount: Money, seconds: Duration, val taxRate: Double) extends RegularPolicy(amount, seconds) with TaxablePolicy {
  override def calculateCallFee(call: Call): Money = {
    amount * (call.duration.getSeconds / seconds.getSeconds)
  }
}
