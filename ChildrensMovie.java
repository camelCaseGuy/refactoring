package refactoring;

public class ChildrensMovie extends Movie {
  
  public ChildrensMovie(String title) {
    super(title);
  }

  public double getAmount(int _daysRented) {
    double thisAmount = 1.5;
    if (_daysRented > 3) {
        thisAmount += (_daysRented - 3) * 1.5;
    }
    return thisAmount;
  }
}