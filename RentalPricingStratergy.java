// Stratergy for rental pricing for different types of movies
public abstract class RentalPricingStratergy {
    public abstract double computeRentalPrice(Rental r);

    // standardCalculation function uses a formula that is used by two movie types to calculate pricing
    // makes it easier to change the formula if it is changed in the future
    public double standardCalculation(Rental r, double rentalFee, int lateThreshold, double latePenalty) {
        if (r.getDaysRented() > lateThreshold) {
            rentalFee += (r.getDaysRented() - lateThreshold) * latePenalty;
        }
        return rentalFee;
    }
} 