package decorator;

import model.Movie;
import model.Purchase;

/**
 * Decorator for adding purchase price to a movie
 */
public class PurchasePriceDecorator extends MovieDecorator {
    private double basePrice;
    
    public PurchasePriceDecorator(Movie movie, double basePrice) {
        super(movie);
        this.basePrice = basePrice;
    }
    
    @Override
    public double getPurchasePrice() {
        // Add the base purchase price to any existing purchase price from decorators
        return super.getPurchasePrice() + basePrice;
    }
}
