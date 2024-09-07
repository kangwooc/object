package chapter9;

import java.time.Duration;

public class Factory {
    public Movie createAvatarMovie() {
        ServiceLocator.provide(new AmountDiscountPolicy(Money.wons(800)));
        return new Movie("아바타", Duration.ofMinutes(120), Money.wons(10000));
    }
}
