package decorator;

import model.Movie;

/**
 * Decorator for adding late fees to any movie type
 */
public class LateFeesDecorator extends MovieDecorator {
    private int lateThreshold;
    private double latePenaltyPerDay;
    
    public LateFeesDecorator(Movie movie, int lateThreshold, double latePenaltyPerDay) {
        super(movie);
        this.lateThreshold = lateThreshold;
        this.latePenaltyPerDay = latePenaltyPerDay;
    }
    
    @Override
    public double getCharge(int daysRented) {
        double charge = super.getCharge(daysRented);
        
        if (daysRented > lateThreshold) {
            // Add late fees
            charge += (daysRented - lateThreshold) * latePenaltyPerDay;
        }
        
        return charge;
    }
}