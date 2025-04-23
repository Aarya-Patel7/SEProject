/**
 * Concrete strategy for children movie pricing
 */
public class ChildrenPriceStrategy implements PriceStrategy {
    @Override
    public double getCharge(int daysRented) {
        double priceCode = 1.5;
        int lateThreshold = 3;
        double latePenalty = 1.5;
        if (daysRented > lateThreshold) {
            priceCode += (daysRented - lateThreshold) * latePenalty;
        }
        return priceCode;
    }
}