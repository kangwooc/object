package chapter5;


import chapter4.MovieType;

import java.time.Duration;
import java.util.List;

public class Movie {
    private String title;
    private Duration runningTime;
    private Money fee;
    private List<DiscountCondition> discountConditions;

    private MovieType movieType;
    private Money discountAmount;
    private Money discountPercent;

    public Money calculateMovieFee(Screening screening) {
        if (isDiscountable(screening)) {
            return fee.minus(calculateDiscountAmount());
        }
        return fee;
    }

    private Money calculateDiscountAmount() {
        switch (movieType) {
            case AMOUNT_DISCOUNT:
                return calculateDiscountAmount();
            case PERCENT_DISCOUNT:
                return calculatePercentDiscountAmount();
            case NONE_DISCOUNT:
                return calculateNoneDiscountAmount();
        }
        throw new IllegalStateException();
    }

    private Money calculateNoneDiscountAmount() {
        return Money.ZERO;
    }

    private Money calculatePercentDiscountAmount() {
        return fee.minus(discountPercent);
    }
    // 다형성을 통해 응집도 문제 해결
    private boolean isDiscountable(Screening screening) {
        return discountConditions.stream().anyMatch(discountCondition -> discountCondition.isSatisfiedBy(screening));
    }
}
