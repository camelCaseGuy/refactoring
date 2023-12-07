package refactoring;

public class Transaction {

	public double applyCoupon(double moviePrice) {
		Coupon tenOff = new TransactionDecorator(new TenDollarsOff());
		moviePrice = tenOff.applyCoupon(moviePrice);

		Coupon halfOff = new TransactionDecorator(new FiftyPercentOffCoupon());
		moviePrice = halfOff.applyCoupon(moviePrice);
		return moviePrice;
	}

	public double applyFreeMovieCoupon(double moviePrice, int frequentRenterPoints) {
		Coupon freeMovie = new TransactionDecorator(new FreeMovie());
		moviePrice = freeMovie.applyCoupon(moviePrice, frequentRenterPoints);
		return moviePrice;
	}

}