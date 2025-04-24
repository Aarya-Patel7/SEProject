// Rental Pricing stratergy for children movies
public class ChildrenPricingStratery extends RentalPricingStratergy{
    public double computeRentalPrice(Rental r) {
        double rentalFee = 1.5;
        int lateThreshold = 3;
        double latePenalty = 1.5;
        return standardCalculation(r, rentalFee, lateThreshold, latePenalty);
    }
}
