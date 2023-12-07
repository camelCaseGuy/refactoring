package src.refactoring;

public class PriceCalculationFactory {
    PriceCalculationStrategy _priceStrategy;

    PriceCalculationFactory() {
    }

    public PriceCalculationStrategy setStrategies(Movie movie) {
        switch (movie.getType()) {
            case "regular":
              _priceStrategy = new RegularMoviePriceCalculationStrategy();
              break;
              
              case "childrens":
              _priceStrategy = new ChildrensPriceCalculationStrategy();
              break;
              
              case "newRelease":
              _priceStrategy = new NewReleasePriceCalculationStrategy();
              
              default:
              _priceStrategy = new PriceCalculationStrategy();
              break;
        }
        return _priceStrategy;
    }

}
