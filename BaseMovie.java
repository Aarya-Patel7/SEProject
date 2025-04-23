package decorator;

import model.Movie;

/**
 * Concrete implementation of the base Movie class
 */
public class BaseMovie extends Movie {
    
    public BaseMovie(String title) {
        super(title);
    }
    
    @Override
    public double getCharge(int daysRented) {
        // Base charge for any movie - this will be decorated
        return 0;
    }
}