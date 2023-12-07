package src.refactoring;

public class ChildrensPointsCalculationStrategy extends PointsCalculationStrategy {
    private int _points;

    public ChildrensPointsCalculationStrategy(int daysRented) {
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
