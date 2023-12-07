package src.refactoring;

public class RegularMoviePointsCalculationStrategy extends PointsCalculationStrategy {
    private int _points;

    RegularMoviePointsCalculationStrategy(int daysRented) {
        setPoints(daysRented);
    }
    @Override
    public int getPoints(){
        return _points;
    }

    @Override
    public void setPoints(int daysRented) {
        _points = daysRented;
    }
}
