public class NewReleaseFrequentRentalPoints implements FrequentRentalStratergy{
    public int getFrequentRenterPoints(Rental r) {
        return r.getDaysRented() > 1 ? 2 : 1;
    }
}
