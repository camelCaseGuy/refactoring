package src.refactoring;

public class RegularMoviePriceCalculationStrategy extends PriceCalculationStrategy {

  @Override
  public double getAmount(double movieAmount, int _daysRented) {
    double thisAmount = 2;
    if (_daysRented > 2) {
      thisAmount += (_daysRented - 2) * 1.5;
    }
    return thisAmount;
  }

}




