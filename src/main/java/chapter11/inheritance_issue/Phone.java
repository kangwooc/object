package chapter11.inheritance_issue;

import java.util.ArrayList;
import java.util.List;

abstract class Phone {
    private List<Call> calls = new ArrayList<>();

    public Money calculateFee() {
        Money result = Money.ZERO;

        for (Call call : calls) {
            result = result.plus(calculateCallFee(call));
        }

        return afterCalculated(result);
    }

    abstract protected Money calculateCallFee(Call call);

    abstract protected Money afterCalculated(Money fee);
}
