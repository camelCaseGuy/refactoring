package refactoring;

public interface Coupon {

    double applyCoupon(double movieAmount);

    double applyCoupon(double movieAmount, int points);
} 