/**
 * Strategy interface for calculating movie rental charges
 */
public interface PriceStrategy {
    double getCharge(int daysRented);
}