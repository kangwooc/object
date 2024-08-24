package chapter2;

public class NoneDiscountPolicy extends DefaultDiscountPolicy {
    @Override
    public Money getDiscountAmount(Screening screening) {
        return Money.ZERO;
    }
}
