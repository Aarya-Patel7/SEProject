/**
 * Strategy for calculating frequent renter points for new releases
 * (2 points for rentals longer than 1 day)
 */
public class NewReleasePointsStrategy implements FrequentRenterPointsStrategy {
    @Override
    public int getFrequentRenterPoints(int daysRented) {
        return daysRented > 1 ? 2 : 1;
    }
}