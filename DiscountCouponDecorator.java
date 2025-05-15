package decorator;

import model.Movie;
import model.Rental;

/**
 * Decorator for applying percentage discount coupons to a rental
 */
public class DiscountCouponDecorator extends MovieDecorator {
    private double discountPercentage;
    
    /**
     * Creates a discount coupon decorator
     * @param movie The movie to decorate
     * @param discountPercentage The discount percentage (0-100)
     */
    public DiscountCouponDecorator(Movie movie, double discountPercentage) {
        super(movie);
        this.discountPercentage = discountPercentage;
    }
    
    @Override
    public double getCharge(int daysRented) {
        double originalCharge = super.getCharge(daysRented);
        double discount = originalCharge * (discountPercentage / 100);
        return originalCharge - discount;
    }
}