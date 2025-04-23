/**
 * Movie class that uses strategy patterns for price and points calculation
 */
public class Movie {
    private String title;
    private PriceStrategy priceStrategy;
    private FrequentRenterPointsStrategy pointsStrategy;

    public Movie(String title, PriceStrategy priceStrategy, FrequentRenterPointsStrategy pointsStrategy) {
        this.title = title;
        this.priceStrategy = priceStrategy;
        this.pointsStrategy = pointsStrategy;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getCharge(int daysRented) {
        return priceStrategy.getCharge(daysRented);
    }

    public int getFrequentRenterPoints(int daysRented) {
        return pointsStrategy.getFrequentRenterPoints(daysRented);
    }

    public void setPriceStrategy(PriceStrategy priceStrategy) {
        this.priceStrategy = priceStrategy;
    }

    public void setPointsStrategy(FrequentRenterPointsStrategy pointsStrategy) {
        this.pointsStrategy = pointsStrategy;
    }
}