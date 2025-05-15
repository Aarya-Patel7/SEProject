package decorator;

import model.Movie;
import model.Purchase;

/**
 * Decorator for applying discounts to movie purchases
 */
public class PurchaseDiscountDecorator extends MovieDecorator {
    private double discountPercentage;
    
    public PurchaseDiscountDecorator(Movie movie, double discountPercentage) {
        super(movie);
        this.discountPercentage = discountPercentage;
    }
    
    @Override
    public double getPurchasePrice() {
        double originalPrice = super.getPurchasePrice();
        double discount = originalPrice * (discountPercentage / 100);
        return originalPrice - discount;
    }
}