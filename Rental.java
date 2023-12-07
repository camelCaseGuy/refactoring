package refactoring;

public class Rental {
  private Movie _movie;
  private int _daysRented;
  private double moviePrice;
  private PriceCalculationStrategy _priceStrategy;
  private PointsCalculationStrategy _pointsStrategy;
  private PriceCalculationFactory _priceFactory;
  private PointsCalculationFactory _pointsFactory;
  private Transaction transaction;

  public Rental(Movie movie, int daysRented) {
    _daysRented = daysRented;
    _movie = movie;
    _priceFactory = new PriceCalculationFactory();
    _priceStrategy = _priceFactory.setStrategies(movie);
    _pointsFactory = new PointsCalculationFactory(daysRented);
    _pointsStrategy = _pointsFactory.setStrategies(movie);
    this.transaction = new Transaction();
  }

  public double calculateRentalAmount(double movieAmount) {
    double rentalAmount;
    rentalAmount = _priceStrategy.getAmount(movieAmount, _daysRented);
    rentalAmount = transaction.applyCoupon(rentalAmount);
    moviePrice = rentalAmount;
    return rentalAmount;
  }


public boolean isFreeMovie(int frequentRenterPoints) {
  double movieAmount = transaction.applyFreeMovieCoupon(moviePrice, frequentRenterPoints);

  if (movieAmount == 0) {
    return true;
  } else {
    return false;
  }
}
  public PriceCalculationStrategy setStrategies() {
    return _priceStrategy;
  }

  public PointsCalculationStrategy getPointsStrategy() {
    return _pointsStrategy;
  }

  public int getDaysRented() {
    return _daysRented;
  }

  public Movie getMovie() {
    return _movie;
  }

  public double getAmount() {
    return _priceStrategy.getAmount(moviePrice, _daysRented);
  }

  public int getPoints() {
    return _pointsStrategy.getPoints();
  }

}