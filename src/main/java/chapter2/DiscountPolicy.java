package chapter2;

public interface DiscountPolicy {
    Money getDiscountAmount(Screening screening);
}
