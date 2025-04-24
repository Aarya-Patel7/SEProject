public abstract class RentalPricingStratergy {
    public abstract double computeRentalPrice(Rental r);
    public double standardCalculation(Rental r, double rentalFee, int lateThreshold, double latePenalty) {
        if (r.getDaysRented() > lateThreshold) {
            rentalFee += (r.getDaysRented() - lateThreshold) * latePenalty;
        }
        return rentalFee;
    }
} 