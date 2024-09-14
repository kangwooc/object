package chapter10;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class Phone {
    private Money amount;
    private Duration seconds;
    private List<Call> calls = new ArrayList<>();

    public Phone(Money amount, Duration seconds, List<Call> calls) {
        this.amount = amount;
        this.seconds = seconds;
        this.calls = calls;
    }

    public Money calculateFee() {
        Money result = Money.ZERO;
        for (Call call : calls) {
            result = result.plus(this.calculateCallFee(call));
        }
        return result;
    }

    private Money calculateCallFee(Call call) {
        return amount.times(call.getDuration().getSeconds() / seconds.getSeconds());
    }
}
