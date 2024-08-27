package chapter5.methodcohesion;

import chapter4.*;

public class ReservationAgency {
    public Reservation reserve(Screening screening, Customer customer, int audienceCount) {
        boolean discountable = checkDiscountable(screening);
        Money fee = calculateFee(screening, discountable, audienceCount);
        return createReservation(screening, customer, audienceCount, fee);
    }

    private Reservation createReservation(Screening screening, Customer customer, int audienceCount, Money fee) {
        return new Reservation(customer, screening, fee, audienceCount);
    }

    private Money calculateFee(Screening screening, boolean discountable, int audienceCount) {
        if (discountable) {
            return screening.getMovie().getFee()
                    .minus(calculateDiscountedFee(screening.getMovie()))
                    .times(audienceCount);
        }
        return screening.getMovie().getFee().times(audienceCount);
    }

    private Money calculateDiscountedFee(Movie movie) {
        switch (movie.getMovieType()) {
            case AMOUNT_DISCOUNT:
                return calculateAmountDiscountedFee(movie);
            case PERCENT_DISCOUNT:
                return calculatePercentDiscountedFee(movie);
            case NONE_DISCOUNT:
                return calculateNoneDiscountedFee(movie);
        }
        throw new IllegalArgumentException();
    }

    private Money calculateAmountDiscountedFee(Movie movie) {
        return movie.calculateAmountDiscountFee();
    }

    private Money calculatePercentDiscountedFee(Movie movie) {
        return movie.calculatePercentDiscountFee();
    }

    private Money calculateNoneDiscountedFee(Movie movie) {
        return movie.calculateNoneDiscountFee();
    }

    private boolean checkDiscountable(Screening screening) {
        return screening.getMovie().getDiscountConditions().stream()
                .anyMatch(discountCondition -> isDiscountable(discountCondition, screening));
    }

    private boolean isDiscountable(DiscountCondition discountCondition, Screening screening) {
        if (discountCondition.getType() == DiscountConditionType.PERIOD) {
            return isSatisfiedByPeriod(discountCondition, screening);
        }
        return isSatisfiedBySequence(discountCondition, screening);
    }

    private boolean isSatisfiedBySequence(DiscountCondition discountCondition, Screening screening) {
        return discountCondition.getSequence() == screening.getSequence();
    }

    private boolean isSatisfiedByPeriod(DiscountCondition discountCondition, Screening screening) {
        return screening.getWhenScreened().equals(discountCondition.getDayOfWeek()) &&
                discountCondition.getStartTime().compareTo(screening.getWhenScreened().toLocalTime()) <= 0 &&
                discountCondition.getEndTime().compareTo(screening.getWhenScreened().toLocalTime()) >= 0;
    }
}
