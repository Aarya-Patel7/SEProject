// Different stratergy for calculating charge based on daysRented
public class ChildrenMovie extends Movie {

    public ChildrenMovie(String title) {
        super(title);
    }

    @Override
    public double getCharge(int daysRented) {
        double rentalFee = 1.5;
        int lateThreshold = 3;
        double latePenalty = 1.5;
        if (daysRented > lateThreshold) {
            rentalFee += (daysRented - lateThreshold) * latePenalty;
        }
        return rentalFee;
    }
}
