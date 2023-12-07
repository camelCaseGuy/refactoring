package refactoring;

public class PointsCalculationStrategy {
    private int _points;

    PointsCalculationStrategy(int _daysRented) {
        setPoints(_daysRented);
    }

    public PointsCalculationStrategy() {
    }

    public int getPoints() {
        // _frequentRentalPoints++;
        // int getBonusPoints = _priceStrategy.getBonusPoints(_daysRented);
        // _frequentRentalPoints += getBonusPoints;
        // return _frequentRentalPoints;
        return _points;
    }

    public void setPoints(int daysRented){
        _points = daysRented;
    }
}
