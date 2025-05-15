// Customer rents a movie
public class Rental extends Item {
    // How long the rental was
    private int daysRented;
    // Pricing stratergy to get price of your rental movie
    private RentalPricingStratergy pricingStratergy;
    // Stratergy to get reward points for this rental movie
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

    // Gets price of renting this movie
    @Override
    public double getPrice() {
        return pricingStratergy.computeRentalPrice(this);
    }

    // Gets reward points from renting this movie
    @Override
    public int getRewardPoints() {
        return frequentRentalStratergy.getFrequentRenterPoints(this);
    }
}