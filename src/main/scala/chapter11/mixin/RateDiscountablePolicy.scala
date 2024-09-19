trait RateDiscountablePolicy extends BasicRatePolicy {
  val discountAmount: Money

  override protected def calculateFee(phone: Phone): Money = {
    val fee = super.calculateFee(phone)
    fee - discountAmount
  }
}
