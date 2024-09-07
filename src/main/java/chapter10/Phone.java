package chapter10;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class Phone {
    private Money amount;
    private Duration seconds;
    private List<Call> calls = new ArrayList<>();
    private double taxRate;

    public Phone(Money amount, Duration seconds, double taxRate) {
        this.amount = amount;
        this.seconds = seconds;
        // 세율 추가시에 수정을 두곳에서 해줘야하는 이슈 발생!
        this.taxRate = taxRate;
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
            result.plus(amount.times(call.getDuration().getSeconds() / seconds.getSeconds()));
        }

        return result.plus(result.times(taxRate));
    }
}
