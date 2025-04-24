public class Rental {
    private Movie movie;
    private int daysRented;
    private RentalPricingStratergy pricingStratergy;
    private FrequentRentalStratergy frequentRentalStratergy;

    public Rental(Movie movie, RentalPricingStratergy pricingStratergy, FrequentRentalStratergy frequentRentalStratergy, int daysRented) {
        this.movie = movie;
        this.daysRented = daysRented;
        this.pricingStratergy = pricingStratergy;
        this.frequentRentalStratergy = frequentRentalStratergy;
    }

    public int getDaysRented() {
        return daysRented;
    }

    public Movie getMovie() {
        return movie;
    }

    public double calculateCharge() {
        return pricingStratergy.computeRentalPrice(this);
    }

    public int calculateFrequentRenterPoints() {
        return frequentRentalStratergy.getFrequentRenterPoints(this);
    }
}