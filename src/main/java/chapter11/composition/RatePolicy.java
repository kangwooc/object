package chapter11.composition;

public interface RatePolicy {
    Money calculateFee(Phone phone);
}
