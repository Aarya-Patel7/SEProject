// Parent class Movie
// Contains Movie specific info and stratergy for calculating charge and frequent renter points
public abstract class Movie {
    private String title;

    public Movie (String title) {
        this.title = title;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public abstract double getCharge(int daysRented);

    public int getFrequentRenterPoints(int daysRented) {
        return 1;
    }
}
