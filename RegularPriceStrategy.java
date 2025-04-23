/**
 * Concrete strategy for regular movie pricing
 */
public class RegularPriceStrategy implements PriceStrategy {
    @Override
    public double getCharge(int daysRented) {
        double priceCode = 2;
        int lateThreshold = 2;
        double latePenalty = 1.5;
        if (daysRented > lateThreshold) {
            priceCode += (daysRented - lateThreshold) * latePenalty;
        }
        return priceCode;
    }
}