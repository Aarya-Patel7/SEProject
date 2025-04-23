/**
 * Strategy interface for calculating frequent renter points
 */
public interface FrequentRenterPointsStrategy {
    int getFrequentRenterPoints(int daysRented);
}