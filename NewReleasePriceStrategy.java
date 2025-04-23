/**
 * Concrete strategy for new release movie pricing
 */
public class NewReleasePriceStrategy implements PriceStrategy {
    @Override
    public double getCharge(int daysRented) {
        int multiplier = 3;
        return daysRented * multiplier;
    }
}