package decorator;

import model.Movie;

/**
 * Abstract decorator class for all movie decorators
 */
public abstract class MovieDecorator extends Movie {
    protected Movie decoratedMovie;
    
    public MovieDecorator(Movie movie) {
        super(movie.getTitle());
        this.decoratedMovie = movie;
    }
    
    @Override
    public double getCharge(int daysRented) {
        return decoratedMovie.getCharge(daysRented);
    }
    
    @Override
    public int getFrequentRenterPoints(int daysRented) {
        return decoratedMovie.getFrequentRenterPoints(daysRented);
    }
}