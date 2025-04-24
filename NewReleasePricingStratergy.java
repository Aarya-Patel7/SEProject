// Pricing strategy for New Release Movies
public class NewReleasePricingStratergy extends RentalPricingStratergy{
    public double computeRentalPrice(Rental r) {
        int multiplier = 3;
        return r.getDaysRented() * multiplier;
    }
}
