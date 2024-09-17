package chapter11.mixin

trait RatePolicy {
  def calculateFee(phone: Phone): Money
}
