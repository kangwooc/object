package chapter2;

import java.time.Duration;

public class Main {
    public static void main(String[] args) {
        Movie avatar = new Movie("아바타", Duration.ofMinutes(120), Money.wons(10000), new AmountDiscountPolicy(Money.wons(800)));
        Movie starwars = new Movie("스타워즈", Duration.ofMinutes(210), Money.wons(10000), new NoneDiscountPolicy());
    }
}
