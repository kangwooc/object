package chapter10;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

// 가장 단순하게 심야할인 구현
public class NightlyDiscountPhone extends Phone {
    private static final int LATE_NIGHT_HOUR = 22;

    private Money nightlyAmount;
    private Money regularAmount;
    private Duration seconds;
    private List<Call> calls = new ArrayList<>();

    public NightlyDiscountPhone(Money nightlyAmount, Money regularAmount, Duration seconds) {
        super(regularAmount, seconds);
        this.nightlyAmount = nightlyAmount;
    }

    @Override
    public Money calculateFee() {
        Money result = super.calculateFee();

        Money nightlyFee = Money.ZERO;

        for (Call call : getCalls()) {
            if (call.getFrom().getHour() >= LATE_NIGHT_HOUR) {
                nightlyFee = nightlyFee.plus(
                        nightlyAmount.times(call.getDuration().getSeconds() / seconds.getSeconds())
                );
            }
        }

        return result.minus(nightlyFee);
    }
}
