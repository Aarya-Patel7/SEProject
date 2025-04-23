/**
 * Standard strategy for calculating frequent renter points (1 point per rental)
 */
public class StandardPointsStrategy implements FrequentRenterPointsStrategy {
    @Override
    public int getFrequentRenterPoints(int daysRented) {
        return 1;
    }
}