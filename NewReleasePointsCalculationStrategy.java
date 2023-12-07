package refactoring;

public class NewReleasePointsCalculationStrategy extends PointsCalculationStrategy {
    int _points;

    public NewReleasePointsCalculationStrategy(int _daysRented) {
        setPoints(_daysRented);
    }

    @Override
    public int getPoints() {

        return _points;
    }

    @Override
    public void setPoints(int daysRented) {
        _points = (daysRented - 1) * 2;
    }
    
}
