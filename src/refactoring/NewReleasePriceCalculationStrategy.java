package src.refactoring;

public class NewReleasePriceCalculationStrategy extends PriceCalculationStrategy {
  
  @Override
  public double getAmount(double movieAmount, int _daysRented) {
    double thisAmount = _daysRented * 3; // 3 is BASE_PRICE
    return thisAmount;
  }

}
