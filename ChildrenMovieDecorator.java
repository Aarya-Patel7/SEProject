package decorator;

import model.Movie;

/**
 * Decorator for Children Movies
 */
public class ChildrenMovieDecorator extends MovieDecorator {
    
    public ChildrenMovieDecorator(Movie movie) {
        super(movie);
    }
    
    @Override
    public double getCharge(int daysRented) {
        // Children movie base price is 1.5
        return super.getCharge(daysRented) + 1.5;
    }
}