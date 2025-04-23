package decorator;

import model.Movie;

/**
 * Decorator for adding bonus frequent renter points
 */
public class BonusPointsDecorator extends MovieDecorator {
    private int bonusPoints;
    
    public BonusPointsDecorator(Movie movie, int bonusPoints) {
        super(movie);
        this.bonusPoints = bonusPoints;
    }
    
    @Override
    public int getFrequentRenterPoints(int daysRented) {
        return super.getFrequentRenterPoints(daysRented) + bonusPoints;
    }
}