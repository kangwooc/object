package chapter10;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class Phone {
    private static final int LATE_NIGHT_HOUR = 22;

    enum PhoneType {
        NIGHTLY,
        REGULAR
    }

    private PhoneType type;

    private Money amount;
    private Money nightlyAmount;
    private Money regularAmount;
    private Duration seconds;
    private List<Call> calls = new ArrayList<>();

    public Phone(Money amount, Duration seconds) {
        this(PhoneType.REGULAR, amount, Money.ZERO, Money.ZERO, seconds);
    }

    public Phone(Money nightlyAmount, Money regularAmount, Duration seconds) {
        this(PhoneType.NIGHTLY, Money.ZERO, nightlyAmount, regularAmount, seconds);
    }

    public Phone(PhoneType type, Money amount, Money nightlyAmount, Money regularAmount, Duration seconds) {
        this.amount = amount;
        this.nightlyAmount = nightlyAmount;
        this.regularAmount = regularAmount;
        this.type = type;
        this.seconds = seconds;
    }

    public void call(Call call) {
        calls.add(call);
    }

    public Money getAmount() {
        return amount;
    }

    public Duration getSeconds() {
        return seconds;
    }

    public List<Call> getCalls() {
        return calls;
    }

    public Money calculateFee() {
        Money result = Money.ZERO;

        for (Call call : calls) {
            if (type == PhoneType.REGULAR) {
                result.plus(amount.times(call.getDuration().getSeconds() / seconds.getSeconds()));
            } else {
                if (call.getFrom().getHour() >= LATE_NIGHT_HOUR) {
                    result = result.plus(
                            nightlyAmount.times(call.getDuration().getSeconds() / seconds.getSeconds())
                    );
                } else {
                    result = result.plus(
                            regularAmount.times(call.getDuration().getSeconds() / seconds.getSeconds())
                    );
                }
            }
        }

        return result;
    }
}
