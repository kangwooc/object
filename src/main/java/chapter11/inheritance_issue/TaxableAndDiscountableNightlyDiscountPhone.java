package chapter11.inheritance_issue;

import java.time.Duration;

public class TaxableAndDiscountableNightlyDiscountPhone extends TaxableNightlyDiscountPhone {
    private Money discountAmount;

    public TaxableAndDiscountableNightlyDiscountPhone(Money nightlyAmount, Money regularAmount, Duration seconds, double taxRate, Money discountAmount) {
        super(nightlyAmount, regularAmount, seconds, taxRate);
        this.discountAmount = discountAmount;
    }

    @Override
    protected Money afterCalculated(Money fee) {
        return super.afterCalculated(fee).minus(discountAmount);
    }
}
