package decorator;

import model.Movie;

/**
 * Decorator for applying fixed amount discount coupons with minimum purchase requirement
 */
public class FixedAmountDiscountDecorator extends MovieDecorator {
    private double discountAmount;
    private double minimumRentalAmount;
    
    /**
     * Creates a fixed amount discount decorator
     * @param movie The movie to decorate
     * @param discountAmount The fixed discount amount
     * @param minimumRentalAmount The minimum rental amount required for discount
     */
    public FixedAmountDiscountDecorator(Movie movie, double discountAmount, double minimumRentalAmount) {
        super(movie);
        this.discountAmount = discountAmount;
        this.minimumRentalAmount = minimumRentalAmount;
    }
    
    @Override
    public double getCharge(int daysRented) {
        double originalCharge = super.getCharge(daysRented);
        
        // Only apply discount if rental amount meets the minimum requirement
        if (originalCharge >= minimumRentalAmount) {
            return Math.max(0, originalCharge - discountAmount);
        }
        
        return originalCharge;
    }
}