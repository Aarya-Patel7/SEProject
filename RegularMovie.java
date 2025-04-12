// Different stratergy for calculating charge based on daysRented
public class RegularMovie extends Movie {

    public RegularMovie(String title) {
        super(title);
    }

    @Override
    public double getCharge(int daysRented) {
        double rentalFee = 2;
        int lateThreshold = 2;
        double latePenalty = 1.5;
        if (daysRented > lateThreshold) {
            rentalFee += (daysRented - lateThreshold) * latePenalty;
        }
        return rentalFee;
    }
}
