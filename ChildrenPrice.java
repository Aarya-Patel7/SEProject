// Class to calculate and return the rental fee for a childrens movie.
public class ChildrenPrice extends Price {
    @Override
    public double getCharge(int daysRented) {
        double rentalFee = 1.5;
        if (daysRented > 3) {
            rentalFee += (daysRented - 3) * 1.5;
        }
        return rentalFee;
    }
}
