public class Movie {
    private String title;
    private Price priceCode;

    public Movie(String title, Price priceCode) {
        this.title = title;
        this.priceCode = priceCode;
    }

    public String getTitle() {
        return title;
    }

    public double getCharge(int daysRented) {
        return priceCode.getCharge(daysRented);
    }

    public int getFrequentRenterPoints(int daysRented) {
        return priceCode.getFrequentRenterPoints(daysRented);
    }
}
