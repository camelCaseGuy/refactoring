package refactoring;
// NOT USED
public class NewReleaseMovie extends Movie {

  public NewReleaseMovie(String title) {
    super(title);
  }

  public double getAmount(int _daysRented) {
    double thisAmount = _daysRented * 3; // 3 is BASE_PRICE
    return thisAmount;
  }

  public int getBonusPoints(int daysRented) {
    if (daysRented > 1) return 1;
    else return 0;
  }
}
