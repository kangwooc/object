package chapter2;

import java.time.Duration;

public class Movie {
    private String title;
    private Duration duration;
    private Money fee;
    private DefaultDiscountPolicy discountPolicy;

    public Movie(String title, Duration duration, Money fee, DefaultDiscountPolicy defaultDiscountPolicy) {
        this.title = title;
        this.duration = duration;
        this.fee = fee;
        this.discountPolicy = defaultDiscountPolicy;
    }

    public Money getFee() {
        return this.fee;
    }

    public Money calculateMoneyFee(Screening screening) {
        return fee.minus(discountPolicy.calculateDiscountAmount(screening));
    }
}
