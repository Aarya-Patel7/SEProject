package decorator;

import model.Movie;

/**
 * Decorator for Regular Movies
 */
public class RegularMovieDecorator extends MovieDecorator {
    
    public RegularMovieDecorator(Movie movie) {
        super(movie);
    }
    
    @Override
    public double getCharge(int daysRented) {
        // Regular movie base price is 2.0
        return super.getCharge(daysRented) + 2.0;
    }
}
