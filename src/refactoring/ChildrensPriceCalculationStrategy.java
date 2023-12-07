package src.refactoring;

public class ChildrensPriceCalculationStrategy extends PriceCalculationStrategy {

  public ChildrensPriceCalculationStrategy(){

  }

  @Override
  public double getAmount(double movieAmount, int daysRented) {
    double thisAmount = 1.5;
    if (daysRented > 3) {
        thisAmount += (daysRented - 3) * 1.5;
    }
    return thisAmount;
  }
}



