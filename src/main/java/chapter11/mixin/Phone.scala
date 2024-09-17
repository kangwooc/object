package chapter11.mixin

import java.util


class Phone(val calls: List[Call], private val ratePolicy: BasicRatePolicy) {
  def calculateFee: Money = ratePolicy.calculateFee(this)
}
