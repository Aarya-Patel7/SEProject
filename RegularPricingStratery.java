// Rental pricing strategy for regular movies
public class RegularPricingStratery extends RentalPricingStratergy{
    public double computeRentalPrice(Rental r) {
        double rentalFee = 2;
        int lateThreshold = 2;
        double latePenalty = 1.5;
        return standardCalculation(r, rentalFee, lateThreshold, latePenalty);
    }
}
