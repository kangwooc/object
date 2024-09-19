import java.math.BigDecimal

case class Money(amount: Long) {
  def +(that: Money): Money = Money(this.amount + that.amount)

  def -(that: Money): Money = Money(this.amount - that.amount)

  def *(times: Double): Money = Money((this.amount.toDouble * times).toLong)

  def isLessThan(other: Money): Boolean = amount.compareTo(other.amount) < 0

  def isGreaterThanOrEqual(other: Money): Boolean = amount.compareTo(other.amount) >= 0
}

object Money {
  val ZERO: Money = Money.wons(0)

  def wons(amount: Long) = new Money(amount)

  def wons(amount: Double) = new Money(amount.toLong)
}

