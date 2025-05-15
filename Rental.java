public class Rental extends Item {
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

    @Override
    public double getPrice() {
        return pricingStratergy.computeRentalPrice(this);
    }

    @Override
    public int getRewardPoints() {
        return frequentRentalStratergy.getFrequentRenterPoints(this);
    }
}