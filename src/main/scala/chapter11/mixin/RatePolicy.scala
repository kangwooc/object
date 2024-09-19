trait RatePolicy {
  def calculateFee(phone: Phone): Money
}
