package chapter10;

import java.util.ArrayList;
import java.util.List;

abstract class Phone {
    private double taxRate;
    private List<Call> calls = new ArrayList<>();

    public Phone(double taxRate) {
        this.taxRate = taxRate;
    }

    public Money calculateFee() {
        Money result = Money.ZERO;

        for (Call call : calls) {
            result = result.plus(calculateCallFee(call));
        }

        return result.plus(taxRate);
    }

    abstract protected Money calculateCallFee(Call call);
}
