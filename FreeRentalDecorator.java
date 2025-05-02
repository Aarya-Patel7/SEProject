package decorator;

import model.Movie;

/**
 * Decorator for applying free rental to a movie
 */
public class FreeRentalDecorator extends MovieDecorator {
    
    public FreeRentalDecorator(Movie movie) {
        super(movie);
    }
    
    @Override
    public double getCharge(int daysRented) {
        // Free rental means zero charge regardless of the decorated movie
        return 0;
    }
    
    @Override
    public int getFrequentRenterPoints(int daysRented) {
        // No frequent renter points for free rentals
        return 0;
    }
}