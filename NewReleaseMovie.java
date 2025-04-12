// Sub-class of movie
// Method for calculating charge and frequent renter points differ from base class Movie
public class NewReleaseMovie extends Movie {

    public NewReleaseMovie(String title) {
        super(title);
    }

    @Override
    public double getCharge(int daysRented) {
        int multiplier = 3;
        return daysRented * multiplier;
    }

    @Override
    public int getFrequentRenterPoints(int daysRented) {
        return daysRented > 1 ? 2 : 1;
    }
}
