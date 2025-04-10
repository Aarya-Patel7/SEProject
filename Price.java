/*  Super class of the different type of movies' prices.
    Provides method structure for calculating and returning the rental fee per movie
    and the amount of renter points given per movie.
*/
public abstract class Price {
    public abstract double getCharge(int daysRented);
    public int getFrequentRenterPoints(int daysRented) {
        return 1;
    }
}
