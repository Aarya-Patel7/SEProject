package decorator;

import model.Movie;
import model.Purchase;

/**
 * Decorator for adding premium purchase points to a movie
 */
public class PremiumPurchaseDecorator extends MovieDecorator {
    private int bonusPurchasePoints;
    
    public PremiumPurchaseDecorator(Movie movie, int bonusPurchasePoints) {
        super(movie);
        this.bonusPurchasePoints = bonusPurchasePoints;
    }
    
    @Override
    public int getPurchasePoints() {
        // Add bonus points for premium purchases
        return super.getPurchasePoints() + bonusPurchasePoints;
    }
}