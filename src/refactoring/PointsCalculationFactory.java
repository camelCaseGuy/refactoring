package src.refactoring;

public class PointsCalculationFactory {
    PointsCalculationStrategy _pointsStrategy;
    int _daysRented;

    PointsCalculationFactory(int daysRented) {
        _daysRented = daysRented;
    }

    public PointsCalculationStrategy setStrategies(Movie movie) {
        switch (movie.getType()) {
            case "regular":
              _pointsStrategy = new RegularMoviePointsCalculationStrategy(_daysRented);
              break;
              
              case "childrens":
              _pointsStrategy = new ChildrensPointsCalculationStrategy(_daysRented);
              break;
              
              case "newRelease":
              _pointsStrategy = new NewReleasePointsCalculationStrategy(_daysRented);
              
              default:
              _pointsStrategy = new PointsCalculationStrategy(_daysRented);
              break;
        }
        return _pointsStrategy;
    }

}