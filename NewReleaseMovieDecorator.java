package decorator;

import model.Movie;

/**
 * Decorator for New Release Movies
 */
public class NewReleaseMovieDecorator extends MovieDecorator {
    
    public NewReleaseMovieDecorator(Movie movie) {
        super(movie);
    }
    
    @Override
    public double getCharge(int daysRented) {
        // New releases are priced per day
        return super.getCharge(daysRented) + (daysRented * 3.0);
    }
    
    @Override
    public int getFrequentRenterPoints(int daysRented) {
        // New releases get bonus points for rentals longer than 1 day
        return daysRented > 1 ? 
               super.getFrequentRenterPoints(daysRented) + 1 : 
               super.getFrequentRenterPoints(daysRented);
    }
}
