// Class to calculate and return the rental fee for a regular movie.
public class RegularPrice extends Price {
    @Override
    public double getCharge(int daysRented) {
        double rentalFee = 2;
        if (daysRented > 2) {
            rentalFee += (daysRented - 2) * 1.5;
        }
        return rentalFee;
    }
}
