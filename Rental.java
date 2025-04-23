/**
 * Rental class that works with the updated Movie class
 */
public class Rental {
    private Movie movie;
    private int daysRented;

    public Rental(Movie movie, int daysRented) {
        this.movie = movie;
        this.daysRented = daysRented;
    }

    public int getDaysRented() {
        return daysRented;
    }

    public Movie getMovie() {
        return movie;
    }

    public double calculateCharge() {
        return movie.getCharge(daysRented);
    }

    public int calculateFrequentRenterPoints() {
        return movie.getFrequentRenterPoints(daysRented);
    }
}
