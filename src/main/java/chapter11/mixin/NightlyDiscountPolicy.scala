package chapter11.mixin

import java.time.Duration

class NightlyDiscountPolicy(val nightlyAmount: Money, val regularAmount: Money, val seconds: Duration) extends BasicRatePolicy {
  override def calculateCallFee(call: Call): Money = {
    if (call.from.getHour >= NightlyDiscountPolicy.LateNightHour) {
      regularAmount * (call.duration.getSeconds / seconds.getSeconds)
    } else {
      nightlyAmount * (call.duration.getSeconds / seconds.getSeconds)
    }
  }
}

object NightlyDiscountPolicy {
  val LateNightHour = 22
}
