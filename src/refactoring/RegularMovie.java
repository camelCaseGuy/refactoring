package src.refactoring;

// migrate to regularMovieStrategy
public class RegularMovie {

  private RegularMoviePriceCalculationStrategy _regularMoviePriceCalculationStrategy;

  // public RegularMovie(String title, RegularMoviePriceCalculationStrategy
  // strategy) {
  public RegularMovie(String title) {
    // super(title);
    // _regularMoviePriceCalculationStrategy = strategy;

  }

  public RegularMovie(String title, RegularMoviePriceCalculationStrategy strategy) {

    _regularMoviePriceCalculationStrategy = strategy;

  }

  public double getAmount(double movieAmount, int _daysRented) {
    
    
    if (_daysRented > 2) {
      movieAmount += (_daysRented - 2) * 1.5;
    }

    return _regularMoviePriceCalculationStrategy.getAmount(movieAmount, _daysRented);
  }

  // public double getAmount() {
  // return _regularMoviePriceCalculationStrategy.getAmount(this);
  // }

}
