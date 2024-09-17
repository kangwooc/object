package chapter11.mixin

trait TaxablePolicy extends BasicRatePolicy {
  def taxRate: Double
  override def calculateFee(phone: Phone): Money = {
    val fee = super.calculateFee(phone)
    return fee + fee * taxRate
  }
}
